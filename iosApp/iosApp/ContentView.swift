import SwiftUI
import rawgSdk

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel
    var body: some View {
        listView()
    }
    private func listView() -> AnyView {
        switch viewModel.launches {
        case .loading:
            return AnyView(Text("Loading...").multilineTextAlignment(.center))
        case .result(let launches):
            return AnyView(List(launches, id: \.self) { launch in
                Text(launch.name)
            })
        case .error(let description):
            return AnyView(Text(description).multilineTextAlignment(.center))
        }
    }
    
    
    
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(viewModel: ContentView.ViewModel(sdk: RawgSDK(databaseDriverFactory: DatabaseDriverFactory())))
    }
}

extension ContentView {
    enum LoadableLaunches {
        case loading
        case result([Game])
        case error(String)
    }

    class ViewModel: ObservableObject {
        let sdk: RawgSDK
        @Published var launches = LoadableLaunches.loading

        init(sdk: RawgSDK) {
            self.sdk = sdk
            self.loadLaunches(forceReload: false)
        }

        func loadLaunches(forceReload: Bool) {
            self.launches = .loading
            sdk.getLaunches(forceReload: forceReload, completionHandler: { launches, error in
                if let launches = launches {
                    self.launches = .result(launches)
                } else {
                    self.launches = .error(error?.localizedDescription ?? "error")
                }
            })
        }
    }
}
