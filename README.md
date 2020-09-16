# Plan
Just pure api for now. no caching, paging or etc. handle this in each platform.
is it possible to use database but the methods is visible to android or ios.
if this is possible then it can used with dropbox/Store.

for android
caching will be managed by Store.
for ios
@TODO find out how


NEW PLAN
use actual/ expect pattern. this way we can still use store, even handle paging with jetpack and etc.

NEW PLAN 2
independent query,  like:
this way we can avoid unnecessasy load
sdk.ratingForGame(Int)
sdk.ratingForGames(List<Int>)