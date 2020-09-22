#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class RawgSdkDatabaseDriverFactory, RawgSdkGameListRequestConfig, RawgSdkGame, RawgSdkStatus, RawgSdkKotlinThrowable, RawgSdkResource<__covariant T>, RawgSdkKotlinEnum<E>, RawgSdkGenre, RawgSdkParentPlatform, RawgSdkGamePlatform, RawgSdkRating, RawgSdkShortScreenshot, RawgSdkGameStore, RawgSdkTag, RawgSdkPlatform, RawgSdkRequirement, RawgSdkStore, RawgSdkGameListRequestConfigOrder, RawgSdkCreator, RawgSdkCreator_Job, RawgSdkDeveloper, RawgSdkGame_, RawgSdkGameDetail, RawgSdkGame_Developer, RawgSdkGame_Genre, RawgSdkGame_ParentPlatform, RawgSdkGame_Platform, RawgSdkGame_Publisher, RawgSdkGame_Screenshot, RawgSdkGame_Store, RawgSdkGame_Tag, RawgSdkGenre_, RawgSdkJob, RawgSdkLoadGenreForGame, RawgSdkLoadParentPlatformsForGame, RawgSdkLoadPlatformsForGame, RawgSdkLoadStoresForGame, RawgSdkLoadTagsForGame, RawgSdkPlatform_, RawgSdkPublisher, RawgSdkRating_, RawgSdkRuntimeQuery<__covariant RowType>, RawgSdkStore_, RawgSdkTag_, RawgSdkKotlinArray<T>, RawgSdkRuntimeTransacterTransaction, RawgSdkKotlinException, RawgSdkKotlinRuntimeException, RawgSdkKotlinIllegalStateException, RawgSdkKotlinUnit, RawgSdkKotlinx_serialization_coreSerializersModule, RawgSdkKotlinx_serialization_coreSerialKind, RawgSdkKotlinNothing, RawgSdkKotlinx_serialization_coreUpdateMode, RawgSdkKotlinByteArray, RawgSdkKotlinByteIterator;

@protocol RawgSdkKotlinComparable, RawgSdkRawgDatabaseQueries, RawgSdkKotlinx_serialization_coreKSerializer, RawgSdkRuntimeSqlDriver, RawgSdkRuntimeTransactionWithoutReturn, RawgSdkRuntimeTransactionWithReturn, RawgSdkRuntimeTransacter, RawgSdkRawgDatabase, RawgSdkRuntimeSqlDriverSchema, RawgSdkKotlinx_coroutines_coreFlow, RawgSdkKotlinx_serialization_coreEncoder, RawgSdkKotlinx_serialization_coreSerialDescriptor, RawgSdkKotlinx_serialization_coreSerializationStrategy, RawgSdkKotlinx_serialization_coreDecoder, RawgSdkKotlinx_serialization_coreDeserializationStrategy, RawgSdkRuntimeSqlPreparedStatement, RawgSdkRuntimeSqlCursor, RawgSdkRuntimeCloseable, RawgSdkRuntimeTransactionCallbacks, RawgSdkRuntimeQueryListener, RawgSdkKotlinx_coroutines_coreFlowCollector, RawgSdkKotlinIterator, RawgSdkKotlinx_serialization_coreCompositeEncoder, RawgSdkKotlinAnnotation, RawgSdkKotlinx_serialization_coreCompositeDecoder, RawgSdkKotlinx_serialization_coreSerializersModuleCollector, RawgSdkKotlinKClass, RawgSdkKotlinKDeclarationContainer, RawgSdkKotlinKAnnotatedElement, RawgSdkKotlinKClassifier;

NS_ASSUME_NONNULL_BEGIN
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunknown-warning-option"
#pragma clang diagnostic ignored "-Wincompatible-property-type"
#pragma clang diagnostic ignored "-Wnullability"

__attribute__((swift_name("KotlinBase")))
@interface RawgSdkBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end;

@interface RawgSdkBase (RawgSdkBaseCopying) <NSCopying>
@end;

__attribute__((swift_name("KotlinMutableSet")))
@interface RawgSdkMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end;

__attribute__((swift_name("KotlinMutableDictionary")))
@interface RawgSdkMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end;

@interface NSError (NSErrorRawgSdkKotlinException)
@property (readonly) id _Nullable kotlinException;
@end;

__attribute__((swift_name("KotlinNumber")))
@interface RawgSdkNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end;

__attribute__((swift_name("KotlinByte")))
@interface RawgSdkByte : RawgSdkNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end;

__attribute__((swift_name("KotlinUByte")))
@interface RawgSdkUByte : RawgSdkNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end;

__attribute__((swift_name("KotlinShort")))
@interface RawgSdkShort : RawgSdkNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end;

__attribute__((swift_name("KotlinUShort")))
@interface RawgSdkUShort : RawgSdkNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end;

__attribute__((swift_name("KotlinInt")))
@interface RawgSdkInt : RawgSdkNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end;

__attribute__((swift_name("KotlinUInt")))
@interface RawgSdkUInt : RawgSdkNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end;

__attribute__((swift_name("KotlinLong")))
@interface RawgSdkLong : RawgSdkNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end;

__attribute__((swift_name("KotlinULong")))
@interface RawgSdkULong : RawgSdkNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end;

__attribute__((swift_name("KotlinFloat")))
@interface RawgSdkFloat : RawgSdkNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end;

__attribute__((swift_name("KotlinDouble")))
@interface RawgSdkDouble : RawgSdkNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end;

__attribute__((swift_name("KotlinBoolean")))
@interface RawgSdkBoolean : RawgSdkNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("RawgSDK")))
@interface RawgSdkRawgSDK : RawgSdkBase
- (instancetype)initWithDatabaseDriverFactory:(RawgSdkDatabaseDriverFactory *)databaseDriverFactory __attribute__((swift_name("init(databaseDriverFactory:)"))) __attribute__((objc_designated_initializer));

/**
 @note This method converts instances of Exception to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)getGamesForceReload:(BOOL)forceReload config:(RawgSdkGameListRequestConfig *)config completionHandler:(void (^)(NSArray<RawgSdkGame *> * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getGames(forceReload:config:completionHandler:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("RawgSDK.Companion")))
@interface RawgSdkRawgSDKCompanion : RawgSdkBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (readonly) NSString * _Nullable TAG __attribute__((swift_name("TAG")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Resource")))
@interface RawgSdkResource<__covariant T> : RawgSdkBase
- (instancetype)initWithStatus:(RawgSdkStatus *)status data:(T _Nullable)data error:(RawgSdkKotlinThrowable * _Nullable)error __attribute__((swift_name("init(status:data:error:)"))) __attribute__((objc_designated_initializer));
- (RawgSdkStatus *)component1 __attribute__((swift_name("component1()")));
- (T _Nullable)component2 __attribute__((swift_name("component2()")));
- (RawgSdkKotlinThrowable * _Nullable)component3 __attribute__((swift_name("component3()")));
- (RawgSdkResource<T> *)doCopyStatus:(RawgSdkStatus *)status data:(T _Nullable)data error:(RawgSdkKotlinThrowable * _Nullable)error __attribute__((swift_name("doCopy(status:data:error:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) T _Nullable data __attribute__((swift_name("data")));
@property (readonly) RawgSdkKotlinThrowable * _Nullable error __attribute__((swift_name("error")));
@property (readonly) RawgSdkStatus *status __attribute__((swift_name("status")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ResourceCompanion")))
@interface RawgSdkResourceCompanion : RawgSdkBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (RawgSdkResource<NSArray<id> *> *)empty __attribute__((swift_name("empty()")));
- (RawgSdkResource<id> *)errorError:(RawgSdkKotlinThrowable *)error data:(id _Nullable)data __attribute__((swift_name("error(error:data:)")));
- (RawgSdkResource<id> *)loadingData:(id _Nullable)data __attribute__((swift_name("loading(data:)")));
- (RawgSdkResource<id> *)successData:(id _Nullable)data __attribute__((swift_name("success(data:)")));
@end;

__attribute__((swift_name("KotlinComparable")))
@protocol RawgSdkKotlinComparable
@required
- (int32_t)compareToOther:(id _Nullable)other __attribute__((swift_name("compareTo(other:)")));
@end;

__attribute__((swift_name("KotlinEnum")))
@interface RawgSdkKotlinEnum<E> : RawgSdkBase <RawgSdkKotlinComparable>
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer));
- (int32_t)compareToOther:(E)other __attribute__((swift_name("compareTo(other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) int32_t ordinal __attribute__((swift_name("ordinal")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Status")))
@interface RawgSdkStatus : RawgSdkKotlinEnum<RawgSdkStatus *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) RawgSdkStatus *success __attribute__((swift_name("success")));
@property (class, readonly) RawgSdkStatus *error __attribute__((swift_name("error")));
@property (class, readonly) RawgSdkStatus *loading __attribute__((swift_name("loading")));
@property (class, readonly) RawgSdkStatus *empty __attribute__((swift_name("empty")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Game")))
@interface RawgSdkGame : RawgSdkBase
- (instancetype)initWithId:(int32_t)id next:(NSString * _Nullable)next prev:(NSString * _Nullable)prev slug:(NSString * _Nullable)slug name:(NSString *)name released:(NSString * _Nullable)released tba:(BOOL)tba backgroundImage:(NSString * _Nullable)backgroundImage rating:(float)rating ratingTop:(float)ratingTop ratingsCount:(int32_t)ratingsCount reviewsTextCount:(int32_t)reviewsTextCount added:(int32_t)added metacritic:(int32_t)metacritic playtime:(int32_t)playtime suggestionsCount:(int32_t)suggestionsCount reviewsCount:(int32_t)reviewsCount saturatedColor:(NSString * _Nullable)saturatedColor dominantColor:(NSString * _Nullable)dominantColor clip:(NSString * _Nullable)clip dbQuery:(id<RawgSdkRawgDatabaseQueries>)dbQuery __attribute__((swift_name("init(id:next:prev:slug:name:released:tba:backgroundImage:rating:ratingTop:ratingsCount:reviewsTextCount:added:metacritic:playtime:suggestionsCount:reviewsCount:saturatedColor:dominantColor:clip:dbQuery:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (float)component10 __attribute__((swift_name("component10()")));
- (int32_t)component11 __attribute__((swift_name("component11()")));
- (int32_t)component12 __attribute__((swift_name("component12()")));
- (int32_t)component13 __attribute__((swift_name("component13()")));
- (int32_t)component14 __attribute__((swift_name("component14()")));
- (int32_t)component15 __attribute__((swift_name("component15()")));
- (int32_t)component16 __attribute__((swift_name("component16()")));
- (int32_t)component17 __attribute__((swift_name("component17()")));
- (NSString * _Nullable)component18 __attribute__((swift_name("component18()")));
- (NSString * _Nullable)component19 __attribute__((swift_name("component19()")));
- (NSString * _Nullable)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component20 __attribute__((swift_name("component20()")));
- (id<RawgSdkRawgDatabaseQueries>)component21 __attribute__((swift_name("component21()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (NSString * _Nullable)component4 __attribute__((swift_name("component4()")));
- (NSString *)component5 __attribute__((swift_name("component5()")));
- (NSString * _Nullable)component6 __attribute__((swift_name("component6()")));
- (BOOL)component7 __attribute__((swift_name("component7()")));
- (NSString * _Nullable)component8 __attribute__((swift_name("component8()")));
- (float)component9 __attribute__((swift_name("component9()")));
- (RawgSdkGame *)doCopyId:(int32_t)id next:(NSString * _Nullable)next prev:(NSString * _Nullable)prev slug:(NSString * _Nullable)slug name:(NSString *)name released:(NSString * _Nullable)released tba:(BOOL)tba backgroundImage:(NSString * _Nullable)backgroundImage rating:(float)rating ratingTop:(float)ratingTop ratingsCount:(int32_t)ratingsCount reviewsTextCount:(int32_t)reviewsTextCount added:(int32_t)added metacritic:(int32_t)metacritic playtime:(int32_t)playtime suggestionsCount:(int32_t)suggestionsCount reviewsCount:(int32_t)reviewsCount saturatedColor:(NSString * _Nullable)saturatedColor dominantColor:(NSString * _Nullable)dominantColor clip:(NSString * _Nullable)clip dbQuery:(id<RawgSdkRawgDatabaseQueries>)dbQuery __attribute__((swift_name("doCopy(id:next:prev:slug:name:released:tba:backgroundImage:rating:ratingTop:ratingsCount:reviewsTextCount:added:metacritic:playtime:suggestionsCount:reviewsCount:saturatedColor:dominantColor:clip:dbQuery:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSArray<RawgSdkGenre *> *)genres __attribute__((swift_name("genres()")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSArray<RawgSdkParentPlatform *> *)parentPlatforms __attribute__((swift_name("parentPlatforms()")));
- (NSArray<RawgSdkGamePlatform *> *)platforms __attribute__((swift_name("platforms()")));
- (NSArray<RawgSdkRating *> *)ratings __attribute__((swift_name("ratings()")));
- (NSArray<RawgSdkShortScreenshot *> *)shortScreenshots __attribute__((swift_name("shortScreenshots()")));
- (NSArray<RawgSdkGameStore *> *)stores __attribute__((swift_name("stores()")));
- (NSArray<RawgSdkTag *> *)tags __attribute__((swift_name("tags()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t added __attribute__((swift_name("added")));
@property (readonly) NSString * _Nullable backgroundImage __attribute__((swift_name("backgroundImage")));
@property (readonly) NSString * _Nullable clip __attribute__((swift_name("clip")));
@property (readonly) id<RawgSdkRawgDatabaseQueries> dbQuery __attribute__((swift_name("dbQuery")));
@property (readonly) NSString * _Nullable dominantColor __attribute__((swift_name("dominantColor")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) int32_t metacritic __attribute__((swift_name("metacritic")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString * _Nullable next __attribute__((swift_name("next")));
@property (readonly) int32_t playtime __attribute__((swift_name("playtime")));
@property (readonly) NSString * _Nullable prev __attribute__((swift_name("prev")));
@property (readonly) float rating __attribute__((swift_name("rating")));
@property (readonly) float ratingTop __attribute__((swift_name("ratingTop")));
@property (readonly) int32_t ratingsCount __attribute__((swift_name("ratingsCount")));
@property (readonly) NSString * _Nullable released __attribute__((swift_name("released")));
@property (readonly) int32_t reviewsCount __attribute__((swift_name("reviewsCount")));
@property (readonly) int32_t reviewsTextCount __attribute__((swift_name("reviewsTextCount")));
@property (readonly) NSString * _Nullable saturatedColor __attribute__((swift_name("saturatedColor")));
@property (readonly) NSString * _Nullable slug __attribute__((swift_name("slug")));
@property (readonly) int32_t suggestionsCount __attribute__((swift_name("suggestionsCount")));
@property (readonly) BOOL tba __attribute__((swift_name("tba")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GamePlatform")))
@interface RawgSdkGamePlatform : RawgSdkBase
- (instancetype)initWithGameId:(int32_t)gameId platform:(RawgSdkPlatform *)platform releasedAt:(NSString * _Nullable)releasedAt requirementsEn:(RawgSdkRequirement * _Nullable)requirementsEn __attribute__((swift_name("init(gameId:platform:releasedAt:requirementsEn:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (RawgSdkPlatform *)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (RawgSdkRequirement * _Nullable)component4 __attribute__((swift_name("component4()")));
- (RawgSdkGamePlatform *)doCopyGameId:(int32_t)gameId platform:(RawgSdkPlatform *)platform releasedAt:(NSString * _Nullable)releasedAt requirementsEn:(RawgSdkRequirement * _Nullable)requirementsEn __attribute__((swift_name("doCopy(gameId:platform:releasedAt:requirementsEn:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t gameId __attribute__((swift_name("gameId")));
@property (readonly) RawgSdkPlatform *platform __attribute__((swift_name("platform")));
@property (readonly) NSString * _Nullable releasedAt __attribute__((swift_name("releasedAt")));
@property (readonly) RawgSdkRequirement * _Nullable requirementsEn __attribute__((swift_name("requirementsEn")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GameStore")))
@interface RawgSdkGameStore : RawgSdkBase
- (instancetype)initWithGameId:(int32_t)gameId id:(int32_t)id store:(RawgSdkStore *)store urlEn:(NSString * _Nullable)urlEn __attribute__((swift_name("init(gameId:id:store:urlEn:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (RawgSdkStore *)component3 __attribute__((swift_name("component3()")));
- (NSString * _Nullable)component4 __attribute__((swift_name("component4()")));
- (RawgSdkGameStore *)doCopyGameId:(int32_t)gameId id:(int32_t)id store:(RawgSdkStore *)store urlEn:(NSString * _Nullable)urlEn __attribute__((swift_name("doCopy(gameId:id:store:urlEn:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t gameId __attribute__((swift_name("gameId")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) RawgSdkStore *store __attribute__((swift_name("store")));
@property (readonly) NSString * _Nullable urlEn __attribute__((swift_name("urlEn")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Genre")))
@interface RawgSdkGenre : RawgSdkBase
- (instancetype)initWithGameId:(int32_t)gameId id:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(RawgSdkInt * _Nullable)gamesCount imageBackground:(NSString * _Nullable)imageBackground __attribute__((swift_name("init(gameId:id:name:slug:gamesCount:imageBackground:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (NSString * _Nullable)component4 __attribute__((swift_name("component4()")));
- (RawgSdkInt * _Nullable)component5 __attribute__((swift_name("component5()")));
- (NSString * _Nullable)component6 __attribute__((swift_name("component6()")));
- (RawgSdkGenre *)doCopyGameId:(int32_t)gameId id:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(RawgSdkInt * _Nullable)gamesCount imageBackground:(NSString * _Nullable)imageBackground __attribute__((swift_name("doCopy(gameId:id:name:slug:gamesCount:imageBackground:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t gameId __attribute__((swift_name("gameId")));
@property (readonly) RawgSdkInt * _Nullable gamesCount __attribute__((swift_name("gamesCount")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) NSString * _Nullable imageBackground __attribute__((swift_name("imageBackground")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString * _Nullable slug __attribute__((swift_name("slug")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ParentPlatform")))
@interface RawgSdkParentPlatform : RawgSdkBase
- (instancetype)initWithGameId:(int32_t)gameId id:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug __attribute__((swift_name("init(gameId:id:name:slug:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (NSString * _Nullable)component4 __attribute__((swift_name("component4()")));
- (RawgSdkParentPlatform *)doCopyGameId:(int32_t)gameId id:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug __attribute__((swift_name("doCopy(gameId:id:name:slug:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t gameId __attribute__((swift_name("gameId")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString * _Nullable slug __attribute__((swift_name("slug")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Platform")))
@interface RawgSdkPlatform : RawgSdkBase
- (instancetype)initWithId:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug image:(NSString * _Nullable)image yearEnd:(RawgSdkInt * _Nullable)yearEnd yearStart:(RawgSdkInt * _Nullable)yearStart gamesCount:(RawgSdkInt * _Nullable)gamesCount imageBackground:(NSString * _Nullable)imageBackground __attribute__((swift_name("init(id:name:slug:image:yearEnd:yearStart:gamesCount:imageBackground:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (NSString * _Nullable)component4 __attribute__((swift_name("component4()")));
- (RawgSdkInt * _Nullable)component5 __attribute__((swift_name("component5()")));
- (RawgSdkInt * _Nullable)component6 __attribute__((swift_name("component6()")));
- (RawgSdkInt * _Nullable)component7 __attribute__((swift_name("component7()")));
- (NSString * _Nullable)component8 __attribute__((swift_name("component8()")));
- (RawgSdkPlatform *)doCopyId:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug image:(NSString * _Nullable)image yearEnd:(RawgSdkInt * _Nullable)yearEnd yearStart:(RawgSdkInt * _Nullable)yearStart gamesCount:(RawgSdkInt * _Nullable)gamesCount imageBackground:(NSString * _Nullable)imageBackground __attribute__((swift_name("doCopy(id:name:slug:image:yearEnd:yearStart:gamesCount:imageBackground:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) RawgSdkInt * _Nullable gamesCount __attribute__((swift_name("gamesCount")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) NSString * _Nullable image __attribute__((swift_name("image")));
@property (readonly) NSString * _Nullable imageBackground __attribute__((swift_name("imageBackground")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString * _Nullable slug __attribute__((swift_name("slug")));
@property (readonly) RawgSdkInt * _Nullable yearEnd __attribute__((swift_name("yearEnd")));
@property (readonly) RawgSdkInt * _Nullable yearStart __attribute__((swift_name("yearStart")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Rating")))
@interface RawgSdkRating : RawgSdkBase
- (instancetype)initWithId:(int32_t)id gameId:(int32_t)gameId title:(NSString *)title count:(int32_t)count percent:(float)percent __attribute__((swift_name("init(id:gameId:title:count:percent:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (int32_t)component4 __attribute__((swift_name("component4()")));
- (float)component5 __attribute__((swift_name("component5()")));
- (RawgSdkRating *)doCopyId:(int32_t)id gameId:(int32_t)gameId title:(NSString *)title count:(int32_t)count percent:(float)percent __attribute__((swift_name("doCopy(id:gameId:title:count:percent:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t count __attribute__((swift_name("count")));
@property (readonly) int32_t gameId __attribute__((swift_name("gameId")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) float percent __attribute__((swift_name("percent")));
@property (readonly) NSString *title __attribute__((swift_name("title")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Requirement")))
@interface RawgSdkRequirement : RawgSdkBase
- (instancetype)initWithMinimum:(NSString * _Nullable)minimum recommended:(NSString * _Nullable)recommended __attribute__((swift_name("init(minimum:recommended:)"))) __attribute__((objc_designated_initializer));
- (NSString * _Nullable)component1 __attribute__((swift_name("component1()")));
- (NSString * _Nullable)component2 __attribute__((swift_name("component2()")));
- (RawgSdkRequirement *)doCopyMinimum:(NSString * _Nullable)minimum recommended:(NSString * _Nullable)recommended __attribute__((swift_name("doCopy(minimum:recommended:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable minimum __attribute__((swift_name("minimum")));
@property (readonly) NSString * _Nullable recommended __attribute__((swift_name("recommended")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ShortScreenshot")))
@interface RawgSdkShortScreenshot : RawgSdkBase
- (instancetype)initWithGameId:(int32_t)gameId id:(int32_t)id image:(NSString * _Nullable)image __attribute__((swift_name("init(gameId:id:image:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (RawgSdkShortScreenshot *)doCopyGameId:(int32_t)gameId id:(int32_t)id image:(NSString * _Nullable)image __attribute__((swift_name("doCopy(gameId:id:image:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t gameId __attribute__((swift_name("gameId")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) NSString * _Nullable image __attribute__((swift_name("image")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Store")))
@interface RawgSdkStore : RawgSdkBase
- (instancetype)initWithId:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug domain:(NSString * _Nullable)domain gamesCount:(RawgSdkInt * _Nullable)gamesCount imageBackground:(NSString * _Nullable)imageBackground __attribute__((swift_name("init(id:name:slug:domain:gamesCount:imageBackground:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (NSString * _Nullable)component4 __attribute__((swift_name("component4()")));
- (RawgSdkInt * _Nullable)component5 __attribute__((swift_name("component5()")));
- (NSString * _Nullable)component6 __attribute__((swift_name("component6()")));
- (RawgSdkStore *)doCopyId:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug domain:(NSString * _Nullable)domain gamesCount:(RawgSdkInt * _Nullable)gamesCount imageBackground:(NSString * _Nullable)imageBackground __attribute__((swift_name("doCopy(id:name:slug:domain:gamesCount:imageBackground:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable domain __attribute__((swift_name("domain")));
@property (readonly) RawgSdkInt * _Nullable gamesCount __attribute__((swift_name("gamesCount")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) NSString * _Nullable imageBackground __attribute__((swift_name("imageBackground")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString * _Nullable slug __attribute__((swift_name("slug")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Tag")))
@interface RawgSdkTag : RawgSdkBase
- (instancetype)initWithGameId:(int32_t)gameId id:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug language:(NSString * _Nullable)language gamesCount:(RawgSdkInt * _Nullable)gamesCount imageBackground:(NSString * _Nullable)imageBackground __attribute__((swift_name("init(gameId:id:name:slug:language:gamesCount:imageBackground:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (NSString * _Nullable)component4 __attribute__((swift_name("component4()")));
- (NSString * _Nullable)component5 __attribute__((swift_name("component5()")));
- (RawgSdkInt * _Nullable)component6 __attribute__((swift_name("component6()")));
- (NSString * _Nullable)component7 __attribute__((swift_name("component7()")));
- (RawgSdkTag *)doCopyGameId:(int32_t)gameId id:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug language:(NSString * _Nullable)language gamesCount:(RawgSdkInt * _Nullable)gamesCount imageBackground:(NSString * _Nullable)imageBackground __attribute__((swift_name("doCopy(gameId:id:name:slug:language:gamesCount:imageBackground:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t gameId __attribute__((swift_name("gameId")));
@property (readonly) RawgSdkInt * _Nullable gamesCount __attribute__((swift_name("gamesCount")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) NSString * _Nullable imageBackground __attribute__((swift_name("imageBackground")));
@property (readonly) NSString * _Nullable language __attribute__((swift_name("language")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString * _Nullable slug __attribute__((swift_name("slug")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GameListRequestConfig")))
@interface RawgSdkGameListRequestConfig : RawgSdkBase
- (instancetype)initWithPage:(RawgSdkInt * _Nullable)page pageSize:(RawgSdkInt * _Nullable)pageSize search:(NSString * _Nullable)search parentPlatforms:(NSSet<RawgSdkInt *> *)parentPlatforms platforms:(NSSet<RawgSdkInt *> *)platforms stores:(NSSet<RawgSdkInt *> *)stores developers:(NSSet<RawgSdkInt *> *)developers publishers:(NSSet<RawgSdkInt *> *)publishers genres:(NSSet<RawgSdkInt *> *)genres tags:(NSSet<RawgSdkInt *> *)tags creators:(NSSet<RawgSdkInt *> *)creators __attribute__((swift_name("init(page:pageSize:search:parentPlatforms:platforms:stores:developers:publishers:genres:tags:creators:)"))) __attribute__((objc_designated_initializer));
- (RawgSdkInt * _Nullable)component1 __attribute__((swift_name("component1()")));
- (NSSet<RawgSdkInt *> *)component10 __attribute__((swift_name("component10()")));
- (NSSet<RawgSdkInt *> *)component11 __attribute__((swift_name("component11()")));
- (RawgSdkInt * _Nullable)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (NSSet<RawgSdkInt *> *)component4 __attribute__((swift_name("component4()")));
- (NSSet<RawgSdkInt *> *)component5 __attribute__((swift_name("component5()")));
- (NSSet<RawgSdkInt *> *)component6 __attribute__((swift_name("component6()")));
- (NSSet<RawgSdkInt *> *)component7 __attribute__((swift_name("component7()")));
- (NSSet<RawgSdkInt *> *)component8 __attribute__((swift_name("component8()")));
- (NSSet<RawgSdkInt *> *)component9 __attribute__((swift_name("component9()")));
- (RawgSdkGameListRequestConfig *)doCopyPage:(RawgSdkInt * _Nullable)page pageSize:(RawgSdkInt * _Nullable)pageSize search:(NSString * _Nullable)search parentPlatforms:(NSSet<RawgSdkInt *> *)parentPlatforms platforms:(NSSet<RawgSdkInt *> *)platforms stores:(NSSet<RawgSdkInt *> *)stores developers:(NSSet<RawgSdkInt *> *)developers publishers:(NSSet<RawgSdkInt *> *)publishers genres:(NSSet<RawgSdkInt *> *)genres tags:(NSSet<RawgSdkInt *> *)tags creators:(NSSet<RawgSdkInt *> *)creators __attribute__((swift_name("doCopy(page:pageSize:search:parentPlatforms:platforms:stores:developers:publishers:genres:tags:creators:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSSet<RawgSdkInt *> *creators __attribute__((swift_name("creators")));
@property (readonly) NSSet<RawgSdkInt *> *developers __attribute__((swift_name("developers")));
@property (readonly) NSSet<RawgSdkInt *> *genres __attribute__((swift_name("genres")));
@property (readonly) RawgSdkInt * _Nullable page __attribute__((swift_name("page")));
@property (readonly) RawgSdkInt * _Nullable pageSize __attribute__((swift_name("pageSize")));
@property (readonly) NSSet<RawgSdkInt *> *parentPlatforms __attribute__((swift_name("parentPlatforms")));
@property (readonly) NSSet<RawgSdkInt *> *platforms __attribute__((swift_name("platforms")));
@property (readonly) NSSet<RawgSdkInt *> *publishers __attribute__((swift_name("publishers")));
@property (readonly) NSString * _Nullable search __attribute__((swift_name("search")));
@property (readonly) NSSet<RawgSdkInt *> *stores __attribute__((swift_name("stores")));
@property (readonly) NSSet<RawgSdkInt *> *tags __attribute__((swift_name("tags")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GameListRequestConfig.Companion")))
@interface RawgSdkGameListRequestConfigCompanion : RawgSdkBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<RawgSdkKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GameListRequestConfig.Order")))
@interface RawgSdkGameListRequestConfigOrder : RawgSdkKotlinEnum<RawgSdkGameListRequestConfigOrder *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) RawgSdkGameListRequestConfigOrder *nameAsc __attribute__((swift_name("nameAsc")));
@property (class, readonly) RawgSdkGameListRequestConfigOrder *releasedAsc __attribute__((swift_name("releasedAsc")));
@property (class, readonly) RawgSdkGameListRequestConfigOrder *addedAsc __attribute__((swift_name("addedAsc")));
@property (class, readonly) RawgSdkGameListRequestConfigOrder *createdAsc __attribute__((swift_name("createdAsc")));
@property (class, readonly) RawgSdkGameListRequestConfigOrder *ratingAsc __attribute__((swift_name("ratingAsc")));
@property (class, readonly) RawgSdkGameListRequestConfigOrder *nameDesc __attribute__((swift_name("nameDesc")));
@property (class, readonly) RawgSdkGameListRequestConfigOrder *releasedDesc __attribute__((swift_name("releasedDesc")));
@property (class, readonly) RawgSdkGameListRequestConfigOrder *addedDesc __attribute__((swift_name("addedDesc")));
@property (class, readonly) RawgSdkGameListRequestConfigOrder *createdDesc __attribute__((swift_name("createdDesc")));
@property (class, readonly) RawgSdkGameListRequestConfigOrder *ratingDesc __attribute__((swift_name("ratingDesc")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("RawgApi")))
@interface RawgSdkRawgApi : RawgSdkBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("RawgApi.Companion")))
@interface RawgSdkRawgApiCompanion : RawgSdkBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Creator")))
@interface RawgSdkCreator : RawgSdkBase
- (instancetype)initWithId:(int32_t)id nextPage:(NSString * _Nullable)nextPage prevPage:(NSString * _Nullable)prevPage name:(NSString *)name slug:(NSString * _Nullable)slug image:(NSString * _Nullable)image imageBackground:(NSString * _Nullable)imageBackground gamesCount:(int64_t)gamesCount __attribute__((swift_name("init(id:nextPage:prevPage:name:slug:image:imageBackground:gamesCount:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (NSString * _Nullable)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (NSString * _Nullable)component5 __attribute__((swift_name("component5()")));
- (NSString * _Nullable)component6 __attribute__((swift_name("component6()")));
- (NSString * _Nullable)component7 __attribute__((swift_name("component7()")));
- (int64_t)component8 __attribute__((swift_name("component8()")));
- (RawgSdkCreator *)doCopyId:(int32_t)id nextPage:(NSString * _Nullable)nextPage prevPage:(NSString * _Nullable)prevPage name:(NSString *)name slug:(NSString * _Nullable)slug image:(NSString * _Nullable)image imageBackground:(NSString * _Nullable)imageBackground gamesCount:(int64_t)gamesCount __attribute__((swift_name("doCopy(id:nextPage:prevPage:name:slug:image:imageBackground:gamesCount:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int64_t gamesCount __attribute__((swift_name("gamesCount")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) NSString * _Nullable image __attribute__((swift_name("image")));
@property (readonly) NSString * _Nullable imageBackground __attribute__((swift_name("imageBackground")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString * _Nullable nextPage __attribute__((swift_name("nextPage")));
@property (readonly) NSString * _Nullable prevPage __attribute__((swift_name("prevPage")));
@property (readonly) NSString * _Nullable slug __attribute__((swift_name("slug")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Creator_Job")))
@interface RawgSdkCreator_Job : RawgSdkBase
- (instancetype)initWithCreatorId:(int32_t)creatorId jobId:(int32_t)jobId __attribute__((swift_name("init(creatorId:jobId:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (RawgSdkCreator_Job *)doCopyCreatorId:(int32_t)creatorId jobId:(int32_t)jobId __attribute__((swift_name("doCopy(creatorId:jobId:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t creatorId __attribute__((swift_name("creatorId")));
@property (readonly) int32_t jobId __attribute__((swift_name("jobId")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DatabaseDriverFactory")))
@interface RawgSdkDatabaseDriverFactory : RawgSdkBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (id<RawgSdkRuntimeSqlDriver>)createDriver __attribute__((swift_name("createDriver()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Developer")))
@interface RawgSdkDeveloper : RawgSdkBase
- (instancetype)initWithId:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug gameCount:(int32_t)gameCount imageBackground:(NSString * _Nullable)imageBackground description:(NSString * _Nullable)description __attribute__((swift_name("init(id:name:slug:gameCount:imageBackground:description:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (int32_t)component4 __attribute__((swift_name("component4()")));
- (NSString * _Nullable)component5 __attribute__((swift_name("component5()")));
- (NSString * _Nullable)component6 __attribute__((swift_name("component6()")));
- (RawgSdkDeveloper *)doCopyId:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug gameCount:(int32_t)gameCount imageBackground:(NSString * _Nullable)imageBackground description:(NSString * _Nullable)description __attribute__((swift_name("doCopy(id:name:slug:gameCount:imageBackground:description:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly, getter=description_) NSString * _Nullable description __attribute__((swift_name("description")));
@property (readonly) int32_t gameCount __attribute__((swift_name("gameCount")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) NSString * _Nullable imageBackground __attribute__((swift_name("imageBackground")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString * _Nullable slug __attribute__((swift_name("slug")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Game_")))
@interface RawgSdkGame_ : RawgSdkBase
- (instancetype)initWithId:(int32_t)id nextPage:(NSString * _Nullable)nextPage prevPage:(NSString * _Nullable)prevPage name:(NSString *)name slug:(NSString * _Nullable)slug released:(NSString * _Nullable)released tba:(BOOL)tba backgroundImage:(NSString * _Nullable)backgroundImage rating:(float)rating ratingTop:(float)ratingTop ratingsCount:(int32_t)ratingsCount reviewTextCount:(int32_t)reviewTextCount added:(int32_t)added metacritic:(int32_t)metacritic playtime:(int32_t)playtime suggestionCount:(int32_t)suggestionCount reviewsCount:(int32_t)reviewsCount saturatedColor:(NSString * _Nullable)saturatedColor dominantColor:(NSString * _Nullable)dominantColor clip:(NSString * _Nullable)clip __attribute__((swift_name("init(id:nextPage:prevPage:name:slug:released:tba:backgroundImage:rating:ratingTop:ratingsCount:reviewTextCount:added:metacritic:playtime:suggestionCount:reviewsCount:saturatedColor:dominantColor:clip:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (float)component10 __attribute__((swift_name("component10()")));
- (int32_t)component11 __attribute__((swift_name("component11()")));
- (int32_t)component12 __attribute__((swift_name("component12()")));
- (int32_t)component13 __attribute__((swift_name("component13()")));
- (int32_t)component14 __attribute__((swift_name("component14()")));
- (int32_t)component15 __attribute__((swift_name("component15()")));
- (int32_t)component16 __attribute__((swift_name("component16()")));
- (int32_t)component17 __attribute__((swift_name("component17()")));
- (NSString * _Nullable)component18 __attribute__((swift_name("component18()")));
- (NSString * _Nullable)component19 __attribute__((swift_name("component19()")));
- (NSString * _Nullable)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component20 __attribute__((swift_name("component20()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (NSString * _Nullable)component5 __attribute__((swift_name("component5()")));
- (NSString * _Nullable)component6 __attribute__((swift_name("component6()")));
- (BOOL)component7 __attribute__((swift_name("component7()")));
- (NSString * _Nullable)component8 __attribute__((swift_name("component8()")));
- (float)component9 __attribute__((swift_name("component9()")));
- (RawgSdkGame_ *)doCopyId:(int32_t)id nextPage:(NSString * _Nullable)nextPage prevPage:(NSString * _Nullable)prevPage name:(NSString *)name slug:(NSString * _Nullable)slug released:(NSString * _Nullable)released tba:(BOOL)tba backgroundImage:(NSString * _Nullable)backgroundImage rating:(float)rating ratingTop:(float)ratingTop ratingsCount:(int32_t)ratingsCount reviewTextCount:(int32_t)reviewTextCount added:(int32_t)added metacritic:(int32_t)metacritic playtime:(int32_t)playtime suggestionCount:(int32_t)suggestionCount reviewsCount:(int32_t)reviewsCount saturatedColor:(NSString * _Nullable)saturatedColor dominantColor:(NSString * _Nullable)dominantColor clip:(NSString * _Nullable)clip __attribute__((swift_name("doCopy(id:nextPage:prevPage:name:slug:released:tba:backgroundImage:rating:ratingTop:ratingsCount:reviewTextCount:added:metacritic:playtime:suggestionCount:reviewsCount:saturatedColor:dominantColor:clip:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t added __attribute__((swift_name("added")));
@property (readonly) NSString * _Nullable backgroundImage __attribute__((swift_name("backgroundImage")));
@property (readonly) NSString * _Nullable clip __attribute__((swift_name("clip")));
@property (readonly) NSString * _Nullable dominantColor __attribute__((swift_name("dominantColor")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) int32_t metacritic __attribute__((swift_name("metacritic")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString * _Nullable nextPage __attribute__((swift_name("nextPage")));
@property (readonly) int32_t playtime __attribute__((swift_name("playtime")));
@property (readonly) NSString * _Nullable prevPage __attribute__((swift_name("prevPage")));
@property (readonly) float rating __attribute__((swift_name("rating")));
@property (readonly) float ratingTop __attribute__((swift_name("ratingTop")));
@property (readonly) int32_t ratingsCount __attribute__((swift_name("ratingsCount")));
@property (readonly) NSString * _Nullable released __attribute__((swift_name("released")));
@property (readonly) int32_t reviewTextCount __attribute__((swift_name("reviewTextCount")));
@property (readonly) int32_t reviewsCount __attribute__((swift_name("reviewsCount")));
@property (readonly) NSString * _Nullable saturatedColor __attribute__((swift_name("saturatedColor")));
@property (readonly) NSString * _Nullable slug __attribute__((swift_name("slug")));
@property (readonly) int32_t suggestionCount __attribute__((swift_name("suggestionCount")));
@property (readonly) BOOL tba __attribute__((swift_name("tba")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GameDetail")))
@interface RawgSdkGameDetail : RawgSdkBase
- (instancetype)initWithId:(int32_t)id backgroundImageAddtional:(NSString * _Nullable)backgroundImageAddtional description:(NSString * _Nullable)description rawDescription:(NSString * _Nullable)rawDescription screenshotsCount:(int32_t)screenshotsCount moviesCount:(int32_t)moviesCount creatorsCount:(int32_t)creatorsCount achievementsCount:(int32_t)achievementsCount parentAchievementsCount:(int32_t)parentAchievementsCount redditUrl:(NSString * _Nullable)redditUrl redditName:(NSString * _Nullable)redditName redditDescription:(NSString * _Nullable)redditDescription redditLogo:(NSString * _Nullable)redditLogo redditCount:(int32_t)redditCount twitchCount:(int32_t)twitchCount youtubeCount:(int32_t)youtubeCount additionsCount:(int32_t)additionsCount seriesCount:(int32_t)seriesCount __attribute__((swift_name("init(id:backgroundImageAddtional:description:rawDescription:screenshotsCount:moviesCount:creatorsCount:achievementsCount:parentAchievementsCount:redditUrl:redditName:redditDescription:redditLogo:redditCount:twitchCount:youtubeCount:additionsCount:seriesCount:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (NSString * _Nullable)component10 __attribute__((swift_name("component10()")));
- (NSString * _Nullable)component11 __attribute__((swift_name("component11()")));
- (NSString * _Nullable)component12 __attribute__((swift_name("component12()")));
- (NSString * _Nullable)component13 __attribute__((swift_name("component13()")));
- (int32_t)component14 __attribute__((swift_name("component14()")));
- (int32_t)component15 __attribute__((swift_name("component15()")));
- (int32_t)component16 __attribute__((swift_name("component16()")));
- (int32_t)component17 __attribute__((swift_name("component17()")));
- (int32_t)component18 __attribute__((swift_name("component18()")));
- (NSString * _Nullable)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (NSString * _Nullable)component4 __attribute__((swift_name("component4()")));
- (int32_t)component5 __attribute__((swift_name("component5()")));
- (int32_t)component6 __attribute__((swift_name("component6()")));
- (int32_t)component7 __attribute__((swift_name("component7()")));
- (int32_t)component8 __attribute__((swift_name("component8()")));
- (int32_t)component9 __attribute__((swift_name("component9()")));
- (RawgSdkGameDetail *)doCopyId:(int32_t)id backgroundImageAddtional:(NSString * _Nullable)backgroundImageAddtional description:(NSString * _Nullable)description rawDescription:(NSString * _Nullable)rawDescription screenshotsCount:(int32_t)screenshotsCount moviesCount:(int32_t)moviesCount creatorsCount:(int32_t)creatorsCount achievementsCount:(int32_t)achievementsCount parentAchievementsCount:(int32_t)parentAchievementsCount redditUrl:(NSString * _Nullable)redditUrl redditName:(NSString * _Nullable)redditName redditDescription:(NSString * _Nullable)redditDescription redditLogo:(NSString * _Nullable)redditLogo redditCount:(int32_t)redditCount twitchCount:(int32_t)twitchCount youtubeCount:(int32_t)youtubeCount additionsCount:(int32_t)additionsCount seriesCount:(int32_t)seriesCount __attribute__((swift_name("doCopy(id:backgroundImageAddtional:description:rawDescription:screenshotsCount:moviesCount:creatorsCount:achievementsCount:parentAchievementsCount:redditUrl:redditName:redditDescription:redditLogo:redditCount:twitchCount:youtubeCount:additionsCount:seriesCount:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t achievementsCount __attribute__((swift_name("achievementsCount")));
@property (readonly) int32_t additionsCount __attribute__((swift_name("additionsCount")));
@property (readonly) NSString * _Nullable backgroundImageAddtional __attribute__((swift_name("backgroundImageAddtional")));
@property (readonly) int32_t creatorsCount __attribute__((swift_name("creatorsCount")));
@property (readonly, getter=description_) NSString * _Nullable description __attribute__((swift_name("description")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) int32_t moviesCount __attribute__((swift_name("moviesCount")));
@property (readonly) int32_t parentAchievementsCount __attribute__((swift_name("parentAchievementsCount")));
@property (readonly) NSString * _Nullable rawDescription __attribute__((swift_name("rawDescription")));
@property (readonly) int32_t redditCount __attribute__((swift_name("redditCount")));
@property (readonly) NSString * _Nullable redditDescription __attribute__((swift_name("redditDescription")));
@property (readonly) NSString * _Nullable redditLogo __attribute__((swift_name("redditLogo")));
@property (readonly) NSString * _Nullable redditName __attribute__((swift_name("redditName")));
@property (readonly) NSString * _Nullable redditUrl __attribute__((swift_name("redditUrl")));
@property (readonly) int32_t screenshotsCount __attribute__((swift_name("screenshotsCount")));
@property (readonly) int32_t seriesCount __attribute__((swift_name("seriesCount")));
@property (readonly) int32_t twitchCount __attribute__((swift_name("twitchCount")));
@property (readonly) int32_t youtubeCount __attribute__((swift_name("youtubeCount")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Game_Developer")))
@interface RawgSdkGame_Developer : RawgSdkBase
- (instancetype)initWithGameId:(int32_t)gameId developerId:(int32_t)developerId __attribute__((swift_name("init(gameId:developerId:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (RawgSdkGame_Developer *)doCopyGameId:(int32_t)gameId developerId:(int32_t)developerId __attribute__((swift_name("doCopy(gameId:developerId:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t developerId __attribute__((swift_name("developerId")));
@property (readonly) int32_t gameId __attribute__((swift_name("gameId")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Game_Genre")))
@interface RawgSdkGame_Genre : RawgSdkBase
- (instancetype)initWithGameId:(int32_t)gameId genreId:(int32_t)genreId __attribute__((swift_name("init(gameId:genreId:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (RawgSdkGame_Genre *)doCopyGameId:(int32_t)gameId genreId:(int32_t)genreId __attribute__((swift_name("doCopy(gameId:genreId:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t gameId __attribute__((swift_name("gameId")));
@property (readonly) int32_t genreId __attribute__((swift_name("genreId")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Game_ParentPlatform")))
@interface RawgSdkGame_ParentPlatform : RawgSdkBase
- (instancetype)initWithGameId:(int32_t)gameId platformId:(int32_t)platformId __attribute__((swift_name("init(gameId:platformId:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (RawgSdkGame_ParentPlatform *)doCopyGameId:(int32_t)gameId platformId:(int32_t)platformId __attribute__((swift_name("doCopy(gameId:platformId:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t gameId __attribute__((swift_name("gameId")));
@property (readonly) int32_t platformId __attribute__((swift_name("platformId")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Game_Platform")))
@interface RawgSdkGame_Platform : RawgSdkBase
- (instancetype)initWithGameId:(int32_t)gameId platformId:(int32_t)platformId releasedAt:(NSString * _Nullable)releasedAt minimumRequirement:(NSString * _Nullable)minimumRequirement recommendedRequirement:(NSString * _Nullable)recommendedRequirement __attribute__((swift_name("init(gameId:platformId:releasedAt:minimumRequirement:recommendedRequirement:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (NSString * _Nullable)component4 __attribute__((swift_name("component4()")));
- (NSString * _Nullable)component5 __attribute__((swift_name("component5()")));
- (RawgSdkGame_Platform *)doCopyGameId:(int32_t)gameId platformId:(int32_t)platformId releasedAt:(NSString * _Nullable)releasedAt minimumRequirement:(NSString * _Nullable)minimumRequirement recommendedRequirement:(NSString * _Nullable)recommendedRequirement __attribute__((swift_name("doCopy(gameId:platformId:releasedAt:minimumRequirement:recommendedRequirement:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t gameId __attribute__((swift_name("gameId")));
@property (readonly) NSString * _Nullable minimumRequirement __attribute__((swift_name("minimumRequirement")));
@property (readonly) int32_t platformId __attribute__((swift_name("platformId")));
@property (readonly) NSString * _Nullable recommendedRequirement __attribute__((swift_name("recommendedRequirement")));
@property (readonly) NSString * _Nullable releasedAt __attribute__((swift_name("releasedAt")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Game_Publisher")))
@interface RawgSdkGame_Publisher : RawgSdkBase
- (instancetype)initWithGameId:(int32_t)gameId publisherId:(int32_t)publisherId __attribute__((swift_name("init(gameId:publisherId:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (RawgSdkGame_Publisher *)doCopyGameId:(int32_t)gameId publisherId:(int32_t)publisherId __attribute__((swift_name("doCopy(gameId:publisherId:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t gameId __attribute__((swift_name("gameId")));
@property (readonly) int32_t publisherId __attribute__((swift_name("publisherId")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Game_Screenshot")))
@interface RawgSdkGame_Screenshot : RawgSdkBase
- (instancetype)initWithId:(int32_t)id gameId:(int32_t)gameId url:(NSString * _Nullable)url __attribute__((swift_name("init(id:gameId:url:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (RawgSdkGame_Screenshot *)doCopyId:(int32_t)id gameId:(int32_t)gameId url:(NSString * _Nullable)url __attribute__((swift_name("doCopy(id:gameId:url:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t gameId __attribute__((swift_name("gameId")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) NSString * _Nullable url __attribute__((swift_name("url")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Game_Store")))
@interface RawgSdkGame_Store : RawgSdkBase
- (instancetype)initWithGameId:(int32_t)gameId storeId:(int32_t)storeId url:(NSString * _Nullable)url __attribute__((swift_name("init(gameId:storeId:url:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (RawgSdkGame_Store *)doCopyGameId:(int32_t)gameId storeId:(int32_t)storeId url:(NSString * _Nullable)url __attribute__((swift_name("doCopy(gameId:storeId:url:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t gameId __attribute__((swift_name("gameId")));
@property (readonly) int32_t storeId __attribute__((swift_name("storeId")));
@property (readonly) NSString * _Nullable url __attribute__((swift_name("url")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Game_Tag")))
@interface RawgSdkGame_Tag : RawgSdkBase
- (instancetype)initWithGameId:(int32_t)gameId tagId:(int32_t)tagId __attribute__((swift_name("init(gameId:tagId:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (RawgSdkGame_Tag *)doCopyGameId:(int32_t)gameId tagId:(int32_t)tagId __attribute__((swift_name("doCopy(gameId:tagId:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t gameId __attribute__((swift_name("gameId")));
@property (readonly) int32_t tagId __attribute__((swift_name("tagId")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Genre_")))
@interface RawgSdkGenre_ : RawgSdkBase
- (instancetype)initWithId:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(int32_t)gamesCount imageBackground:(NSString * _Nullable)imageBackground __attribute__((swift_name("init(id:name:slug:gamesCount:imageBackground:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (int32_t)component4 __attribute__((swift_name("component4()")));
- (NSString * _Nullable)component5 __attribute__((swift_name("component5()")));
- (RawgSdkGenre_ *)doCopyId:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(int32_t)gamesCount imageBackground:(NSString * _Nullable)imageBackground __attribute__((swift_name("doCopy(id:name:slug:gamesCount:imageBackground:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t gamesCount __attribute__((swift_name("gamesCount")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) NSString * _Nullable imageBackground __attribute__((swift_name("imageBackground")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString * _Nullable slug __attribute__((swift_name("slug")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Job")))
@interface RawgSdkJob : RawgSdkBase
- (instancetype)initWithId:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug __attribute__((swift_name("init(id:name:slug:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (RawgSdkJob *)doCopyId:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug __attribute__((swift_name("doCopy(id:name:slug:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString * _Nullable slug __attribute__((swift_name("slug")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("LoadGenreForGame")))
@interface RawgSdkLoadGenreForGame : RawgSdkBase
- (instancetype)initWithGameId:(int32_t)gameId genreId:(int32_t)genreId id:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(int32_t)gamesCount imageBackground:(NSString * _Nullable)imageBackground __attribute__((swift_name("init(gameId:genreId:id:name:slug:gamesCount:imageBackground:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (int32_t)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (NSString * _Nullable)component5 __attribute__((swift_name("component5()")));
- (int32_t)component6 __attribute__((swift_name("component6()")));
- (NSString * _Nullable)component7 __attribute__((swift_name("component7()")));
- (RawgSdkLoadGenreForGame *)doCopyGameId:(int32_t)gameId genreId:(int32_t)genreId id:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(int32_t)gamesCount imageBackground:(NSString * _Nullable)imageBackground __attribute__((swift_name("doCopy(gameId:genreId:id:name:slug:gamesCount:imageBackground:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t gameId __attribute__((swift_name("gameId")));
@property (readonly) int32_t gamesCount __attribute__((swift_name("gamesCount")));
@property (readonly) int32_t genreId __attribute__((swift_name("genreId")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) NSString * _Nullable imageBackground __attribute__((swift_name("imageBackground")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString * _Nullable slug __attribute__((swift_name("slug")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("LoadParentPlatformsForGame")))
@interface RawgSdkLoadParentPlatformsForGame : RawgSdkBase
- (instancetype)initWithGameId:(int32_t)gameId platformId:(int32_t)platformId id:(int32_t)id nextPage:(NSString * _Nullable)nextPage prevPage:(NSString * _Nullable)prevPage name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(int32_t)gamesCount imageBackground:(NSString * _Nullable)imageBackground image:(NSString * _Nullable)image yearStart:(RawgSdkInt * _Nullable)yearStart yearEnd:(RawgSdkInt * _Nullable)yearEnd following:(BOOL)following __attribute__((swift_name("init(gameId:platformId:id:nextPage:prevPage:name:slug:gamesCount:imageBackground:image:yearStart:yearEnd:following:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (NSString * _Nullable)component10 __attribute__((swift_name("component10()")));
- (RawgSdkInt * _Nullable)component11 __attribute__((swift_name("component11()")));
- (RawgSdkInt * _Nullable)component12 __attribute__((swift_name("component12()")));
- (BOOL)component13 __attribute__((swift_name("component13()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (int32_t)component3 __attribute__((swift_name("component3()")));
- (NSString * _Nullable)component4 __attribute__((swift_name("component4()")));
- (NSString * _Nullable)component5 __attribute__((swift_name("component5()")));
- (NSString *)component6 __attribute__((swift_name("component6()")));
- (NSString * _Nullable)component7 __attribute__((swift_name("component7()")));
- (int32_t)component8 __attribute__((swift_name("component8()")));
- (NSString * _Nullable)component9 __attribute__((swift_name("component9()")));
- (RawgSdkLoadParentPlatformsForGame *)doCopyGameId:(int32_t)gameId platformId:(int32_t)platformId id:(int32_t)id nextPage:(NSString * _Nullable)nextPage prevPage:(NSString * _Nullable)prevPage name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(int32_t)gamesCount imageBackground:(NSString * _Nullable)imageBackground image:(NSString * _Nullable)image yearStart:(RawgSdkInt * _Nullable)yearStart yearEnd:(RawgSdkInt * _Nullable)yearEnd following:(BOOL)following __attribute__((swift_name("doCopy(gameId:platformId:id:nextPage:prevPage:name:slug:gamesCount:imageBackground:image:yearStart:yearEnd:following:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) BOOL following __attribute__((swift_name("following")));
@property (readonly) int32_t gameId __attribute__((swift_name("gameId")));
@property (readonly) int32_t gamesCount __attribute__((swift_name("gamesCount")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) NSString * _Nullable image __attribute__((swift_name("image")));
@property (readonly) NSString * _Nullable imageBackground __attribute__((swift_name("imageBackground")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString * _Nullable nextPage __attribute__((swift_name("nextPage")));
@property (readonly) int32_t platformId __attribute__((swift_name("platformId")));
@property (readonly) NSString * _Nullable prevPage __attribute__((swift_name("prevPage")));
@property (readonly) NSString * _Nullable slug __attribute__((swift_name("slug")));
@property (readonly) RawgSdkInt * _Nullable yearEnd __attribute__((swift_name("yearEnd")));
@property (readonly) RawgSdkInt * _Nullable yearStart __attribute__((swift_name("yearStart")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("LoadPlatformsForGame")))
@interface RawgSdkLoadPlatformsForGame : RawgSdkBase
- (instancetype)initWithGameId:(int32_t)gameId platformId:(int32_t)platformId releasedAt:(NSString * _Nullable)releasedAt minimumRequirement:(NSString * _Nullable)minimumRequirement recommendedRequirement:(NSString * _Nullable)recommendedRequirement id:(int32_t)id nextPage:(NSString * _Nullable)nextPage prevPage:(NSString * _Nullable)prevPage name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(int32_t)gamesCount imageBackground:(NSString * _Nullable)imageBackground image:(NSString * _Nullable)image yearStart:(RawgSdkInt * _Nullable)yearStart yearEnd:(RawgSdkInt * _Nullable)yearEnd following:(BOOL)following __attribute__((swift_name("init(gameId:platformId:releasedAt:minimumRequirement:recommendedRequirement:id:nextPage:prevPage:name:slug:gamesCount:imageBackground:image:yearStart:yearEnd:following:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (NSString * _Nullable)component10 __attribute__((swift_name("component10()")));
- (int32_t)component11 __attribute__((swift_name("component11()")));
- (NSString * _Nullable)component12 __attribute__((swift_name("component12()")));
- (NSString * _Nullable)component13 __attribute__((swift_name("component13()")));
- (RawgSdkInt * _Nullable)component14 __attribute__((swift_name("component14()")));
- (RawgSdkInt * _Nullable)component15 __attribute__((swift_name("component15()")));
- (BOOL)component16 __attribute__((swift_name("component16()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (NSString * _Nullable)component4 __attribute__((swift_name("component4()")));
- (NSString * _Nullable)component5 __attribute__((swift_name("component5()")));
- (int32_t)component6 __attribute__((swift_name("component6()")));
- (NSString * _Nullable)component7 __attribute__((swift_name("component7()")));
- (NSString * _Nullable)component8 __attribute__((swift_name("component8()")));
- (NSString *)component9 __attribute__((swift_name("component9()")));
- (RawgSdkLoadPlatformsForGame *)doCopyGameId:(int32_t)gameId platformId:(int32_t)platformId releasedAt:(NSString * _Nullable)releasedAt minimumRequirement:(NSString * _Nullable)minimumRequirement recommendedRequirement:(NSString * _Nullable)recommendedRequirement id:(int32_t)id nextPage:(NSString * _Nullable)nextPage prevPage:(NSString * _Nullable)prevPage name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(int32_t)gamesCount imageBackground:(NSString * _Nullable)imageBackground image:(NSString * _Nullable)image yearStart:(RawgSdkInt * _Nullable)yearStart yearEnd:(RawgSdkInt * _Nullable)yearEnd following:(BOOL)following __attribute__((swift_name("doCopy(gameId:platformId:releasedAt:minimumRequirement:recommendedRequirement:id:nextPage:prevPage:name:slug:gamesCount:imageBackground:image:yearStart:yearEnd:following:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) BOOL following __attribute__((swift_name("following")));
@property (readonly) int32_t gameId __attribute__((swift_name("gameId")));
@property (readonly) int32_t gamesCount __attribute__((swift_name("gamesCount")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) NSString * _Nullable image __attribute__((swift_name("image")));
@property (readonly) NSString * _Nullable imageBackground __attribute__((swift_name("imageBackground")));
@property (readonly) NSString * _Nullable minimumRequirement __attribute__((swift_name("minimumRequirement")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString * _Nullable nextPage __attribute__((swift_name("nextPage")));
@property (readonly) int32_t platformId __attribute__((swift_name("platformId")));
@property (readonly) NSString * _Nullable prevPage __attribute__((swift_name("prevPage")));
@property (readonly) NSString * _Nullable recommendedRequirement __attribute__((swift_name("recommendedRequirement")));
@property (readonly) NSString * _Nullable releasedAt __attribute__((swift_name("releasedAt")));
@property (readonly) NSString * _Nullable slug __attribute__((swift_name("slug")));
@property (readonly) RawgSdkInt * _Nullable yearEnd __attribute__((swift_name("yearEnd")));
@property (readonly) RawgSdkInt * _Nullable yearStart __attribute__((swift_name("yearStart")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("LoadStoresForGame")))
@interface RawgSdkLoadStoresForGame : RawgSdkBase
- (instancetype)initWithGameId:(int32_t)gameId storeId:(int32_t)storeId url:(NSString * _Nullable)url id:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug domain:(NSString * _Nullable)domain gamesCount:(int32_t)gamesCount imageBackground:(NSString * _Nullable)imageBackground following:(BOOL)following __attribute__((swift_name("init(gameId:storeId:url:id:name:slug:domain:gamesCount:imageBackground:following:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (BOOL)component10 __attribute__((swift_name("component10()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (int32_t)component4 __attribute__((swift_name("component4()")));
- (NSString *)component5 __attribute__((swift_name("component5()")));
- (NSString * _Nullable)component6 __attribute__((swift_name("component6()")));
- (NSString * _Nullable)component7 __attribute__((swift_name("component7()")));
- (int32_t)component8 __attribute__((swift_name("component8()")));
- (NSString * _Nullable)component9 __attribute__((swift_name("component9()")));
- (RawgSdkLoadStoresForGame *)doCopyGameId:(int32_t)gameId storeId:(int32_t)storeId url:(NSString * _Nullable)url id:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug domain:(NSString * _Nullable)domain gamesCount:(int32_t)gamesCount imageBackground:(NSString * _Nullable)imageBackground following:(BOOL)following __attribute__((swift_name("doCopy(gameId:storeId:url:id:name:slug:domain:gamesCount:imageBackground:following:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable domain __attribute__((swift_name("domain")));
@property (readonly) BOOL following __attribute__((swift_name("following")));
@property (readonly) int32_t gameId __attribute__((swift_name("gameId")));
@property (readonly) int32_t gamesCount __attribute__((swift_name("gamesCount")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) NSString * _Nullable imageBackground __attribute__((swift_name("imageBackground")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString * _Nullable slug __attribute__((swift_name("slug")));
@property (readonly) int32_t storeId __attribute__((swift_name("storeId")));
@property (readonly) NSString * _Nullable url __attribute__((swift_name("url")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("LoadTagsForGame")))
@interface RawgSdkLoadTagsForGame : RawgSdkBase
- (instancetype)initWithGameId:(int32_t)gameId tagId:(int32_t)tagId id:(int32_t)id nextPage:(NSString * _Nullable)nextPage prevPage:(NSString * _Nullable)prevPage name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(int32_t)gamesCount language:(NSString * _Nullable)language imageBackground:(NSString * _Nullable)imageBackground __attribute__((swift_name("init(gameId:tagId:id:nextPage:prevPage:name:slug:gamesCount:language:imageBackground:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (NSString * _Nullable)component10 __attribute__((swift_name("component10()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (int32_t)component3 __attribute__((swift_name("component3()")));
- (NSString * _Nullable)component4 __attribute__((swift_name("component4()")));
- (NSString * _Nullable)component5 __attribute__((swift_name("component5()")));
- (NSString *)component6 __attribute__((swift_name("component6()")));
- (NSString * _Nullable)component7 __attribute__((swift_name("component7()")));
- (int32_t)component8 __attribute__((swift_name("component8()")));
- (NSString * _Nullable)component9 __attribute__((swift_name("component9()")));
- (RawgSdkLoadTagsForGame *)doCopyGameId:(int32_t)gameId tagId:(int32_t)tagId id:(int32_t)id nextPage:(NSString * _Nullable)nextPage prevPage:(NSString * _Nullable)prevPage name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(int32_t)gamesCount language:(NSString * _Nullable)language imageBackground:(NSString * _Nullable)imageBackground __attribute__((swift_name("doCopy(gameId:tagId:id:nextPage:prevPage:name:slug:gamesCount:language:imageBackground:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t gameId __attribute__((swift_name("gameId")));
@property (readonly) int32_t gamesCount __attribute__((swift_name("gamesCount")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) NSString * _Nullable imageBackground __attribute__((swift_name("imageBackground")));
@property (readonly) NSString * _Nullable language __attribute__((swift_name("language")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString * _Nullable nextPage __attribute__((swift_name("nextPage")));
@property (readonly) NSString * _Nullable prevPage __attribute__((swift_name("prevPage")));
@property (readonly) NSString * _Nullable slug __attribute__((swift_name("slug")));
@property (readonly) int32_t tagId __attribute__((swift_name("tagId")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Platform_")))
@interface RawgSdkPlatform_ : RawgSdkBase
- (instancetype)initWithId:(int32_t)id nextPage:(NSString * _Nullable)nextPage prevPage:(NSString * _Nullable)prevPage name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(int32_t)gamesCount imageBackground:(NSString * _Nullable)imageBackground image:(NSString * _Nullable)image yearStart:(RawgSdkInt * _Nullable)yearStart yearEnd:(RawgSdkInt * _Nullable)yearEnd following:(BOOL)following __attribute__((swift_name("init(id:nextPage:prevPage:name:slug:gamesCount:imageBackground:image:yearStart:yearEnd:following:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (RawgSdkInt * _Nullable)component10 __attribute__((swift_name("component10()")));
- (BOOL)component11 __attribute__((swift_name("component11()")));
- (NSString * _Nullable)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (NSString * _Nullable)component5 __attribute__((swift_name("component5()")));
- (int32_t)component6 __attribute__((swift_name("component6()")));
- (NSString * _Nullable)component7 __attribute__((swift_name("component7()")));
- (NSString * _Nullable)component8 __attribute__((swift_name("component8()")));
- (RawgSdkInt * _Nullable)component9 __attribute__((swift_name("component9()")));
- (RawgSdkPlatform_ *)doCopyId:(int32_t)id nextPage:(NSString * _Nullable)nextPage prevPage:(NSString * _Nullable)prevPage name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(int32_t)gamesCount imageBackground:(NSString * _Nullable)imageBackground image:(NSString * _Nullable)image yearStart:(RawgSdkInt * _Nullable)yearStart yearEnd:(RawgSdkInt * _Nullable)yearEnd following:(BOOL)following __attribute__((swift_name("doCopy(id:nextPage:prevPage:name:slug:gamesCount:imageBackground:image:yearStart:yearEnd:following:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) BOOL following __attribute__((swift_name("following")));
@property (readonly) int32_t gamesCount __attribute__((swift_name("gamesCount")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) NSString * _Nullable image __attribute__((swift_name("image")));
@property (readonly) NSString * _Nullable imageBackground __attribute__((swift_name("imageBackground")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString * _Nullable nextPage __attribute__((swift_name("nextPage")));
@property (readonly) NSString * _Nullable prevPage __attribute__((swift_name("prevPage")));
@property (readonly) NSString * _Nullable slug __attribute__((swift_name("slug")));
@property (readonly) RawgSdkInt * _Nullable yearEnd __attribute__((swift_name("yearEnd")));
@property (readonly) RawgSdkInt * _Nullable yearStart __attribute__((swift_name("yearStart")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Publisher")))
@interface RawgSdkPublisher : RawgSdkBase
- (instancetype)initWithId:(int32_t)id nextPage:(NSString * _Nullable)nextPage prevPage:(NSString * _Nullable)prevPage name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(int32_t)gamesCount imageBackground:(NSString * _Nullable)imageBackground __attribute__((swift_name("init(id:nextPage:prevPage:name:slug:gamesCount:imageBackground:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (NSString * _Nullable)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (NSString * _Nullable)component5 __attribute__((swift_name("component5()")));
- (int32_t)component6 __attribute__((swift_name("component6()")));
- (NSString * _Nullable)component7 __attribute__((swift_name("component7()")));
- (RawgSdkPublisher *)doCopyId:(int32_t)id nextPage:(NSString * _Nullable)nextPage prevPage:(NSString * _Nullable)prevPage name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(int32_t)gamesCount imageBackground:(NSString * _Nullable)imageBackground __attribute__((swift_name("doCopy(id:nextPage:prevPage:name:slug:gamesCount:imageBackground:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t gamesCount __attribute__((swift_name("gamesCount")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) NSString * _Nullable imageBackground __attribute__((swift_name("imageBackground")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString * _Nullable nextPage __attribute__((swift_name("nextPage")));
@property (readonly) NSString * _Nullable prevPage __attribute__((swift_name("prevPage")));
@property (readonly) NSString * _Nullable slug __attribute__((swift_name("slug")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Rating_")))
@interface RawgSdkRating_ : RawgSdkBase
- (instancetype)initWithId:(int32_t)id gameId:(int32_t)gameId title:(NSString *)title count:(int32_t)count percent:(float)percent __attribute__((swift_name("init(id:gameId:title:count:percent:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (int32_t)component2 __attribute__((swift_name("component2()")));
- (NSString *)component3 __attribute__((swift_name("component3()")));
- (int32_t)component4 __attribute__((swift_name("component4()")));
- (float)component5 __attribute__((swift_name("component5()")));
- (RawgSdkRating_ *)doCopyId:(int32_t)id gameId:(int32_t)gameId title:(NSString *)title count:(int32_t)count percent:(float)percent __attribute__((swift_name("doCopy(id:gameId:title:count:percent:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t count __attribute__((swift_name("count")));
@property (readonly) int32_t gameId __attribute__((swift_name("gameId")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) float percent __attribute__((swift_name("percent")));
@property (readonly) NSString *title __attribute__((swift_name("title")));
@end;

__attribute__((swift_name("RuntimeTransacter")))
@protocol RawgSdkRuntimeTransacter
@required
- (void)transactionNoEnclosing:(BOOL)noEnclosing body:(void (^)(id<RawgSdkRuntimeTransactionWithoutReturn>))body __attribute__((swift_name("transaction(noEnclosing:body:)")));
- (id _Nullable)transactionWithResultNoEnclosing:(BOOL)noEnclosing bodyWithReturn:(id _Nullable (^)(id<RawgSdkRuntimeTransactionWithReturn>))bodyWithReturn __attribute__((swift_name("transactionWithResult(noEnclosing:bodyWithReturn:)")));
@end;

__attribute__((swift_name("RawgDatabase")))
@protocol RawgSdkRawgDatabase <RawgSdkRuntimeTransacter>
@required
@property (readonly) id<RawgSdkRawgDatabaseQueries> rawgDatabaseQueries __attribute__((swift_name("rawgDatabaseQueries")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("RawgDatabaseCompanion")))
@interface RawgSdkRawgDatabaseCompanion : RawgSdkBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (id<RawgSdkRawgDatabase>)invokeDriver:(id<RawgSdkRuntimeSqlDriver>)driver __attribute__((swift_name("invoke(driver:)")));
@property (readonly) id<RawgSdkRuntimeSqlDriverSchema> Schema __attribute__((swift_name("Schema")));
@end;

__attribute__((swift_name("RawgDatabaseQueries")))
@protocol RawgSdkRawgDatabaseQueries <RawgSdkRuntimeTransacter>
@required
- (void)clearAllCreators __attribute__((swift_name("clearAllCreators()")));
- (void)clearAllDevelopers __attribute__((swift_name("clearAllDevelopers()")));
- (void)clearAllGameGenres __attribute__((swift_name("clearAllGameGenres()")));
- (void)clearAllGamePublishers __attribute__((swift_name("clearAllGamePublishers()")));
- (void)clearAllGameTags __attribute__((swift_name("clearAllGameTags()")));
- (void)clearAllGames __attribute__((swift_name("clearAllGames()")));
- (void)clearAllGenres __attribute__((swift_name("clearAllGenres()")));
- (void)clearAllJobs __attribute__((swift_name("clearAllJobs()")));
- (void)clearAllPublishers __attribute__((swift_name("clearAllPublishers()")));
- (void)clearCreatorId:(int32_t)id __attribute__((swift_name("clearCreator(id:)")));
- (void)clearCreator_CreatorPositionJobId:(int32_t)jobId __attribute__((swift_name("clearCreator_CreatorPosition(jobId:)")));
- (void)clearCreator_CreatorPositions __attribute__((swift_name("clearCreator_CreatorPositions()")));
- (void)clearDeveloperId:(int32_t)id __attribute__((swift_name("clearDeveloper(id:)")));
- (void)clearGameId:(int32_t)id __attribute__((swift_name("clearGame(id:)")));
- (void)clearGameDetailId:(int32_t)id __attribute__((swift_name("clearGameDetail(id:)")));
- (void)clearGameDetails __attribute__((swift_name("clearGameDetails()")));
- (void)clearGameDevelopers __attribute__((swift_name("clearGameDevelopers()")));
- (void)clearGameParentPlatforms __attribute__((swift_name("clearGameParentPlatforms()")));
- (void)clearGamePlatforms __attribute__((swift_name("clearGamePlatforms()")));
- (void)clearGameScreenshotsByGameIdGameId:(int32_t)gameId __attribute__((swift_name("clearGameScreenshotsByGameId(gameId:)")));
- (void)clearGameStores __attribute__((swift_name("clearGameStores()")));
- (void)clearGenreId:(int32_t)id __attribute__((swift_name("clearGenre(id:)")));
- (void)clearPlatformId:(int32_t)id __attribute__((swift_name("clearPlatform(id:)")));
- (void)clearPlatforms __attribute__((swift_name("clearPlatforms()")));
- (void)clearPublisherId:(int32_t)id __attribute__((swift_name("clearPublisher(id:)")));
- (void)clearRatingId:(int32_t)id __attribute__((swift_name("clearRating(id:)")));
- (void)clearRatings __attribute__((swift_name("clearRatings()")));
- (void)clearStoreId:(int32_t)id __attribute__((swift_name("clearStore(id:)")));
- (void)clearStores __attribute__((swift_name("clearStores()")));
- (void)clearTagId:(int32_t)id __attribute__((swift_name("clearTag(id:)")));
- (void)clearTags __attribute__((swift_name("clearTags()")));
- (void)insertCreatorId:(RawgSdkInt * _Nullable)id nextPage:(NSString * _Nullable)nextPage prevPage:(NSString * _Nullable)prevPage name:(NSString *)name slug:(NSString * _Nullable)slug image:(NSString * _Nullable)image imageBackground:(NSString * _Nullable)imageBackground gamesCount:(int64_t)gamesCount __attribute__((swift_name("insertCreator(id:nextPage:prevPage:name:slug:image:imageBackground:gamesCount:)")));
- (void)insertCreator_CreatorPositionCreatorId:(int32_t)creatorId jobId:(int32_t)jobId __attribute__((swift_name("insertCreator_CreatorPosition(creatorId:jobId:)")));
- (void)insertDeveloperId:(RawgSdkInt * _Nullable)id name:(NSString *)name slug:(NSString * _Nullable)slug gameCount:(int32_t)gameCount imageBackground:(NSString * _Nullable)imageBackground description:(NSString * _Nullable)description __attribute__((swift_name("insertDeveloper(id:name:slug:gameCount:imageBackground:description:)")));
- (void)insertGameId:(RawgSdkInt * _Nullable)id nextPage:(NSString * _Nullable)nextPage prevPage:(NSString * _Nullable)prevPage name:(NSString *)name slug:(NSString * _Nullable)slug released:(NSString * _Nullable)released tba:(BOOL)tba backgroundImage:(NSString * _Nullable)backgroundImage rating:(float)rating ratingTop:(float)ratingTop ratingsCount:(int32_t)ratingsCount reviewTextCount:(int32_t)reviewTextCount added:(int32_t)added metacritic:(int32_t)metacritic playtime:(int32_t)playtime suggestionCount:(int32_t)suggestionCount reviewsCount:(int32_t)reviewsCount saturatedColor:(NSString * _Nullable)saturatedColor dominantColor:(NSString * _Nullable)dominantColor clip:(NSString * _Nullable)clip __attribute__((swift_name("insertGame(id:nextPage:prevPage:name:slug:released:tba:backgroundImage:rating:ratingTop:ratingsCount:reviewTextCount:added:metacritic:playtime:suggestionCount:reviewsCount:saturatedColor:dominantColor:clip:)")));
- (void)insertGameDetailId:(RawgSdkInt * _Nullable)id backgroundImageAddtional:(NSString * _Nullable)backgroundImageAddtional description:(NSString * _Nullable)description rawDescription:(NSString * _Nullable)rawDescription screenshotsCount:(int32_t)screenshotsCount moviesCount:(int32_t)moviesCount creatorsCount:(int32_t)creatorsCount achievementsCount:(int32_t)achievementsCount parentAchievementsCount:(int32_t)parentAchievementsCount redditUrl:(NSString * _Nullable)redditUrl redditName:(NSString * _Nullable)redditName redditDescription:(NSString * _Nullable)redditDescription redditLogo:(NSString * _Nullable)redditLogo redditCount:(int32_t)redditCount twitchCount:(int32_t)twitchCount youtubeCount:(int32_t)youtubeCount additionsCount:(int32_t)additionsCount seriesCount:(int32_t)seriesCount __attribute__((swift_name("insertGameDetail(id:backgroundImageAddtional:description:rawDescription:screenshotsCount:moviesCount:creatorsCount:achievementsCount:parentAchievementsCount:redditUrl:redditName:redditDescription:redditLogo:redditCount:twitchCount:youtubeCount:additionsCount:seriesCount:)")));
- (void)insertGameDeveloperGameId:(int32_t)gameId developerId:(int32_t)developerId __attribute__((swift_name("insertGameDeveloper(gameId:developerId:)")));
- (void)insertGameGenreGameId:(int32_t)gameId genreId:(int32_t)genreId __attribute__((swift_name("insertGameGenre(gameId:genreId:)")));
- (void)insertGameParentPlatformGameId:(int32_t)gameId platformId:(int32_t)platformId __attribute__((swift_name("insertGameParentPlatform(gameId:platformId:)")));
- (void)insertGamePlatformGameId:(int32_t)gameId platformId:(int32_t)platformId releasedAt:(NSString * _Nullable)releasedAt minimumRequirement:(NSString * _Nullable)minimumRequirement recommendedRequirement:(NSString * _Nullable)recommendedRequirement __attribute__((swift_name("insertGamePlatform(gameId:platformId:releasedAt:minimumRequirement:recommendedRequirement:)")));
- (void)insertGamePublisherGameId:(int32_t)gameId publisherId:(int32_t)publisherId __attribute__((swift_name("insertGamePublisher(gameId:publisherId:)")));
- (void)insertGameScreenshotsId:(RawgSdkInt * _Nullable)id gameId:(int32_t)gameId url:(NSString * _Nullable)url __attribute__((swift_name("insertGameScreenshots(id:gameId:url:)")));
- (void)insertGameStoreGameId:(int32_t)gameId storeId:(int32_t)storeId url:(NSString * _Nullable)url __attribute__((swift_name("insertGameStore(gameId:storeId:url:)")));
- (void)insertGameTagGameId:(int32_t)gameId tagId:(int32_t)tagId __attribute__((swift_name("insertGameTag(gameId:tagId:)")));
- (void)insertGenreId:(RawgSdkInt * _Nullable)id name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(int32_t)gamesCount imageBackground:(NSString * _Nullable)imageBackground __attribute__((swift_name("insertGenre(id:name:slug:gamesCount:imageBackground:)")));
- (void)insertJobId:(RawgSdkInt * _Nullable)id name:(NSString *)name slug:(NSString * _Nullable)slug __attribute__((swift_name("insertJob(id:name:slug:)")));
- (void)insertPlatformId:(RawgSdkInt * _Nullable)id nextPage:(NSString * _Nullable)nextPage prevPage:(NSString * _Nullable)prevPage name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(int32_t)gamesCount imageBackground:(NSString * _Nullable)imageBackground image:(NSString * _Nullable)image yearStart:(RawgSdkInt * _Nullable)yearStart yearEnd:(RawgSdkInt * _Nullable)yearEnd following:(BOOL)following __attribute__((swift_name("insertPlatform(id:nextPage:prevPage:name:slug:gamesCount:imageBackground:image:yearStart:yearEnd:following:)")));
- (void)insertPublisherId:(RawgSdkInt * _Nullable)id nextPage:(NSString * _Nullable)nextPage prevPage:(NSString * _Nullable)prevPage name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(int32_t)gamesCount imageBackground:(NSString * _Nullable)imageBackground __attribute__((swift_name("insertPublisher(id:nextPage:prevPage:name:slug:gamesCount:imageBackground:)")));
- (void)insertRatingGameId:(int32_t)gameId title:(NSString *)title count:(int32_t)count percent:(float)percent __attribute__((swift_name("insertRating(gameId:title:count:percent:)")));
- (void)insertStoreId:(RawgSdkInt * _Nullable)id name:(NSString *)name slug:(NSString * _Nullable)slug domain:(NSString * _Nullable)domain gamesCount:(int32_t)gamesCount imageBackground:(NSString * _Nullable)imageBackground following:(BOOL)following __attribute__((swift_name("insertStore(id:name:slug:domain:gamesCount:imageBackground:following:)")));
- (void)insertTagId:(RawgSdkInt * _Nullable)id nextPage:(NSString * _Nullable)nextPage prevPage:(NSString * _Nullable)prevPage name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(int32_t)gamesCount language:(NSString * _Nullable)language imageBackground:(NSString * _Nullable)imageBackground __attribute__((swift_name("insertTag(id:nextPage:prevPage:name:slug:gamesCount:language:imageBackground:)")));
- (RawgSdkRuntimeQuery<RawgSdkGame_ *> *)loadAllGames __attribute__((swift_name("loadAllGames()")));
- (RawgSdkRuntimeQuery<id> *)loadAllGamesMapper:(id (^)(RawgSdkInt *, NSString * _Nullable, NSString * _Nullable, NSString *, NSString * _Nullable, NSString * _Nullable, RawgSdkBoolean *, NSString * _Nullable, RawgSdkFloat *, RawgSdkFloat *, RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, NSString * _Nullable, NSString * _Nullable, NSString * _Nullable))mapper __attribute__((swift_name("loadAllGames(mapper:)")));
- (RawgSdkRuntimeQuery<RawgSdkCreator *> *)loadCreators __attribute__((swift_name("loadCreators()")));
- (RawgSdkRuntimeQuery<id> *)loadCreatorsMapper:(id (^)(RawgSdkInt *, NSString * _Nullable, NSString * _Nullable, NSString *, NSString * _Nullable, NSString * _Nullable, NSString * _Nullable, RawgSdkLong *))mapper __attribute__((swift_name("loadCreators(mapper:)")));
- (RawgSdkRuntimeQuery<RawgSdkDeveloper *> *)loadDevelopers __attribute__((swift_name("loadDevelopers()")));
- (RawgSdkRuntimeQuery<id> *)loadDevelopersMapper:(id (^)(RawgSdkInt *, NSString *, NSString * _Nullable, RawgSdkInt *, NSString * _Nullable, NSString * _Nullable))mapper __attribute__((swift_name("loadDevelopers(mapper:)")));
- (RawgSdkRuntimeQuery<RawgSdkDeveloper *> *)loadDevelopersByIdsId:(int32_t)id __attribute__((swift_name("loadDevelopersByIds(id:)")));
- (RawgSdkRuntimeQuery<id> *)loadDevelopersByIdsId:(int32_t)id mapper:(id (^)(RawgSdkInt *, NSString *, NSString * _Nullable, RawgSdkInt *, NSString * _Nullable, NSString * _Nullable))mapper __attribute__((swift_name("loadDevelopersByIds(id:mapper:)")));
- (RawgSdkRuntimeQuery<RawgSdkGame_ *> *)loadGameId:(int32_t)id __attribute__((swift_name("loadGame(id:)")));
- (RawgSdkRuntimeQuery<id> *)loadGameId:(int32_t)id mapper:(id (^)(RawgSdkInt *, NSString * _Nullable, NSString * _Nullable, NSString *, NSString * _Nullable, NSString * _Nullable, RawgSdkBoolean *, NSString * _Nullable, RawgSdkFloat *, RawgSdkFloat *, RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, NSString * _Nullable, NSString * _Nullable, NSString * _Nullable))mapper __attribute__((swift_name("loadGame(id:mapper:)")));
- (RawgSdkRuntimeQuery<RawgSdkGameDetail *> *)loadGameDetailId:(int32_t)id __attribute__((swift_name("loadGameDetail(id:)")));
- (RawgSdkRuntimeQuery<id> *)loadGameDetailId:(int32_t)id mapper:(id (^)(RawgSdkInt *, NSString * _Nullable, NSString * _Nullable, NSString * _Nullable, RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, NSString * _Nullable, NSString * _Nullable, NSString * _Nullable, NSString * _Nullable, RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, RawgSdkInt *))mapper __attribute__((swift_name("loadGameDetail(id:mapper:)")));
- (RawgSdkRuntimeQuery<RawgSdkGame_ *> *)loadGamesName:(NSString *)name platformId:(id)platformId platformId_:(id)platformId_ storeId:(id)storeId developerId:(id)developerId publisherId:(id)publisherId __attribute__((swift_name("loadGames(name:platformId:platformId_:storeId:developerId:publisherId:)")));
- (RawgSdkRuntimeQuery<id> *)loadGamesName:(NSString *)name platformId:(id)platformId platformId_:(id)platformId_ storeId:(id)storeId developerId:(id)developerId publisherId:(id)publisherId mapper:(id (^)(RawgSdkInt *, NSString * _Nullable, NSString * _Nullable, NSString *, NSString * _Nullable, NSString * _Nullable, RawgSdkBoolean *, NSString * _Nullable, RawgSdkFloat *, RawgSdkFloat *, RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, NSString * _Nullable, NSString * _Nullable, NSString * _Nullable))mapper __attribute__((swift_name("loadGames(name:platformId:platformId_:storeId:developerId:publisherId:mapper:)")));
- (RawgSdkRuntimeQuery<RawgSdkLoadGenreForGame *> *)loadGenreForGameGameId:(int32_t)gameId __attribute__((swift_name("loadGenreForGame(gameId:)")));
- (RawgSdkRuntimeQuery<id> *)loadGenreForGameGameId:(int32_t)gameId mapper:(id (^)(RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, NSString *, NSString * _Nullable, RawgSdkInt *, NSString * _Nullable))mapper __attribute__((swift_name("loadGenreForGame(gameId:mapper:)")));
- (RawgSdkRuntimeQuery<RawgSdkGenre_ *> *)loadGenres __attribute__((swift_name("loadGenres()")));
- (RawgSdkRuntimeQuery<id> *)loadGenresMapper:(id (^)(RawgSdkInt *, NSString *, NSString * _Nullable, RawgSdkInt *, NSString * _Nullable))mapper __attribute__((swift_name("loadGenres(mapper:)")));
- (RawgSdkRuntimeQuery<RawgSdkJob *> *)loadJobByIdId:(int32_t)id __attribute__((swift_name("loadJobById(id:)")));
- (RawgSdkRuntimeQuery<id> *)loadJobByIdId:(int32_t)id mapper:(id (^)(RawgSdkInt *, NSString *, NSString * _Nullable))mapper __attribute__((swift_name("loadJobById(id:mapper:)")));
- (RawgSdkRuntimeQuery<RawgSdkJob *> *)loadJobs __attribute__((swift_name("loadJobs()")));
- (RawgSdkRuntimeQuery<id> *)loadJobsMapper:(id (^)(RawgSdkInt *, NSString *, NSString * _Nullable))mapper __attribute__((swift_name("loadJobs(mapper:)")));
- (RawgSdkRuntimeQuery<RawgSdkLoadParentPlatformsForGame *> *)loadParentPlatformsForGameGameId:(int32_t)gameId __attribute__((swift_name("loadParentPlatformsForGame(gameId:)")));
- (RawgSdkRuntimeQuery<id> *)loadParentPlatformsForGameGameId:(int32_t)gameId mapper:(id (^)(RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, NSString * _Nullable, NSString * _Nullable, NSString *, NSString * _Nullable, RawgSdkInt *, NSString * _Nullable, NSString * _Nullable, RawgSdkInt * _Nullable, RawgSdkInt * _Nullable, RawgSdkBoolean *))mapper __attribute__((swift_name("loadParentPlatformsForGame(gameId:mapper:)")));
- (RawgSdkRuntimeQuery<RawgSdkPlatform_ *> *)loadPlatforms __attribute__((swift_name("loadPlatforms()")));
- (RawgSdkRuntimeQuery<id> *)loadPlatformsMapper:(id (^)(RawgSdkInt *, NSString * _Nullable, NSString * _Nullable, NSString *, NSString * _Nullable, RawgSdkInt *, NSString * _Nullable, NSString * _Nullable, RawgSdkInt * _Nullable, RawgSdkInt * _Nullable, RawgSdkBoolean *))mapper __attribute__((swift_name("loadPlatforms(mapper:)")));
- (RawgSdkRuntimeQuery<RawgSdkLoadPlatformsForGame *> *)loadPlatformsForGameGameId:(int32_t)gameId __attribute__((swift_name("loadPlatformsForGame(gameId:)")));
- (RawgSdkRuntimeQuery<id> *)loadPlatformsForGameGameId:(int32_t)gameId mapper:(id (^)(RawgSdkInt *, RawgSdkInt *, NSString * _Nullable, NSString * _Nullable, NSString * _Nullable, RawgSdkInt *, NSString * _Nullable, NSString * _Nullable, NSString *, NSString * _Nullable, RawgSdkInt *, NSString * _Nullable, NSString * _Nullable, RawgSdkInt * _Nullable, RawgSdkInt * _Nullable, RawgSdkBoolean *))mapper __attribute__((swift_name("loadPlatformsForGame(gameId:mapper:)")));
- (RawgSdkRuntimeQuery<RawgSdkPublisher *> *)loadPublishers __attribute__((swift_name("loadPublishers()")));
- (RawgSdkRuntimeQuery<id> *)loadPublishersMapper:(id (^)(RawgSdkInt *, NSString * _Nullable, NSString * _Nullable, NSString *, NSString * _Nullable, RawgSdkInt *, NSString * _Nullable))mapper __attribute__((swift_name("loadPublishers(mapper:)")));
- (RawgSdkRuntimeQuery<RawgSdkRating_ *> *)loadRatingsGameId:(id)gameId __attribute__((swift_name("loadRatings(gameId:)")));
- (RawgSdkRuntimeQuery<id> *)loadRatingsGameId:(id)gameId mapper:(id (^)(RawgSdkInt *, RawgSdkInt *, NSString *, RawgSdkInt *, RawgSdkFloat *))mapper __attribute__((swift_name("loadRatings(gameId:mapper:)")));
- (RawgSdkRuntimeQuery<RawgSdkRating_ *> *)loadRatingsForGameGameId:(int32_t)gameId __attribute__((swift_name("loadRatingsForGame(gameId:)")));
- (RawgSdkRuntimeQuery<id> *)loadRatingsForGameGameId:(int32_t)gameId mapper:(id (^)(RawgSdkInt *, RawgSdkInt *, NSString *, RawgSdkInt *, RawgSdkFloat *))mapper __attribute__((swift_name("loadRatingsForGame(gameId:mapper:)")));
- (RawgSdkRuntimeQuery<RawgSdkGame_Screenshot *> *)loadScreenshotsForGameGameId:(int32_t)gameId __attribute__((swift_name("loadScreenshotsForGame(gameId:)")));
- (RawgSdkRuntimeQuery<id> *)loadScreenshotsForGameGameId:(int32_t)gameId mapper:(id (^)(RawgSdkInt *, RawgSdkInt *, NSString * _Nullable))mapper __attribute__((swift_name("loadScreenshotsForGame(gameId:mapper:)")));
- (RawgSdkRuntimeQuery<RawgSdkStore_ *> *)loadStores __attribute__((swift_name("loadStores()")));
- (RawgSdkRuntimeQuery<id> *)loadStoresMapper:(id (^)(RawgSdkInt *, NSString *, NSString * _Nullable, NSString * _Nullable, RawgSdkInt *, NSString * _Nullable, RawgSdkBoolean *))mapper __attribute__((swift_name("loadStores(mapper:)")));
- (RawgSdkRuntimeQuery<RawgSdkLoadStoresForGame *> *)loadStoresForGameGameId:(int32_t)gameId __attribute__((swift_name("loadStoresForGame(gameId:)")));
- (RawgSdkRuntimeQuery<id> *)loadStoresForGameGameId:(int32_t)gameId mapper:(id (^)(RawgSdkInt *, RawgSdkInt *, NSString * _Nullable, RawgSdkInt *, NSString *, NSString * _Nullable, NSString * _Nullable, RawgSdkInt *, NSString * _Nullable, RawgSdkBoolean *))mapper __attribute__((swift_name("loadStoresForGame(gameId:mapper:)")));
- (RawgSdkRuntimeQuery<RawgSdkTag_ *> *)loadTags __attribute__((swift_name("loadTags()")));
- (RawgSdkRuntimeQuery<id> *)loadTagsMapper:(id (^)(RawgSdkInt *, NSString * _Nullable, NSString * _Nullable, NSString *, NSString * _Nullable, RawgSdkInt *, NSString * _Nullable, NSString * _Nullable))mapper __attribute__((swift_name("loadTags(mapper:)")));
- (RawgSdkRuntimeQuery<RawgSdkLoadTagsForGame *> *)loadTagsForGameGameId:(int32_t)gameId __attribute__((swift_name("loadTagsForGame(gameId:)")));
- (RawgSdkRuntimeQuery<id> *)loadTagsForGameGameId:(int32_t)gameId mapper:(id (^)(RawgSdkInt *, RawgSdkInt *, RawgSdkInt *, NSString * _Nullable, NSString * _Nullable, NSString *, NSString * _Nullable, RawgSdkInt *, NSString * _Nullable, NSString * _Nullable))mapper __attribute__((swift_name("loadTagsForGame(gameId:mapper:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Store_")))
@interface RawgSdkStore_ : RawgSdkBase
- (instancetype)initWithId:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug domain:(NSString * _Nullable)domain gamesCount:(int32_t)gamesCount imageBackground:(NSString * _Nullable)imageBackground following:(BOOL)following __attribute__((swift_name("init(id:name:slug:domain:gamesCount:imageBackground:following:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (NSString * _Nullable)component4 __attribute__((swift_name("component4()")));
- (int32_t)component5 __attribute__((swift_name("component5()")));
- (NSString * _Nullable)component6 __attribute__((swift_name("component6()")));
- (BOOL)component7 __attribute__((swift_name("component7()")));
- (RawgSdkStore_ *)doCopyId:(int32_t)id name:(NSString *)name slug:(NSString * _Nullable)slug domain:(NSString * _Nullable)domain gamesCount:(int32_t)gamesCount imageBackground:(NSString * _Nullable)imageBackground following:(BOOL)following __attribute__((swift_name("doCopy(id:name:slug:domain:gamesCount:imageBackground:following:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable domain __attribute__((swift_name("domain")));
@property (readonly) BOOL following __attribute__((swift_name("following")));
@property (readonly) int32_t gamesCount __attribute__((swift_name("gamesCount")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) NSString * _Nullable imageBackground __attribute__((swift_name("imageBackground")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString * _Nullable slug __attribute__((swift_name("slug")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Tag_")))
@interface RawgSdkTag_ : RawgSdkBase
- (instancetype)initWithId:(int32_t)id nextPage:(NSString * _Nullable)nextPage prevPage:(NSString * _Nullable)prevPage name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(int32_t)gamesCount language:(NSString * _Nullable)language imageBackground:(NSString * _Nullable)imageBackground __attribute__((swift_name("init(id:nextPage:prevPage:name:slug:gamesCount:language:imageBackground:)"))) __attribute__((objc_designated_initializer));
- (int32_t)component1 __attribute__((swift_name("component1()")));
- (NSString * _Nullable)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (NSString *)component4 __attribute__((swift_name("component4()")));
- (NSString * _Nullable)component5 __attribute__((swift_name("component5()")));
- (int32_t)component6 __attribute__((swift_name("component6()")));
- (NSString * _Nullable)component7 __attribute__((swift_name("component7()")));
- (NSString * _Nullable)component8 __attribute__((swift_name("component8()")));
- (RawgSdkTag_ *)doCopyId:(int32_t)id nextPage:(NSString * _Nullable)nextPage prevPage:(NSString * _Nullable)prevPage name:(NSString *)name slug:(NSString * _Nullable)slug gamesCount:(int32_t)gamesCount language:(NSString * _Nullable)language imageBackground:(NSString * _Nullable)imageBackground __attribute__((swift_name("doCopy(id:nextPage:prevPage:name:slug:gamesCount:language:imageBackground:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t gamesCount __attribute__((swift_name("gamesCount")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property (readonly) NSString * _Nullable imageBackground __attribute__((swift_name("imageBackground")));
@property (readonly) NSString * _Nullable language __attribute__((swift_name("language")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString * _Nullable nextPage __attribute__((swift_name("nextPage")));
@property (readonly) NSString * _Nullable prevPage __attribute__((swift_name("prevPage")));
@property (readonly) NSString * _Nullable slug __attribute__((swift_name("slug")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ExtKt")))
@interface RawgSdkExtKt : RawgSdkBase

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
+ (void)flattenToList:(id<RawgSdkKotlinx_coroutines_coreFlow>)receiver completionHandler:(void (^)(NSArray<id> * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("flattenToList(_:completionHandler:)")));
@end;

__attribute__((swift_name("KotlinThrowable")))
@interface RawgSdkKotlinThrowable : RawgSdkBase
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(RawgSdkKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(RawgSdkKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (RawgSdkKotlinArray<NSString *> *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) RawgSdkKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
@end;

__attribute__((swift_name("KotlinException")))
@interface RawgSdkKotlinException : RawgSdkKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(RawgSdkKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(RawgSdkKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerializationStrategy")))
@protocol RawgSdkKotlinx_serialization_coreSerializationStrategy
@required
- (void)serializeEncoder:(id<RawgSdkKotlinx_serialization_coreEncoder>)encoder value:(id _Nullable)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<RawgSdkKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreDeserializationStrategy")))
@protocol RawgSdkKotlinx_serialization_coreDeserializationStrategy
@required
- (id _Nullable)deserializeDecoder:(id<RawgSdkKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (id _Nullable)patchDecoder:(id<RawgSdkKotlinx_serialization_coreDecoder>)decoder old:(id _Nullable)old __attribute__((swift_name("patch(decoder:old:)"))) __attribute__((unavailable("Patch function is deprecated for removal since this functionality is no longer supported by serializer.Some formats may provide implementation-specific patching in their Decoders.")));
@property (readonly) id<RawgSdkKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreKSerializer")))
@protocol RawgSdkKotlinx_serialization_coreKSerializer <RawgSdkKotlinx_serialization_coreSerializationStrategy, RawgSdkKotlinx_serialization_coreDeserializationStrategy>
@required
@end;

__attribute__((swift_name("RuntimeCloseable")))
@protocol RawgSdkRuntimeCloseable
@required
- (void)close __attribute__((swift_name("close()")));
@end;

__attribute__((swift_name("RuntimeSqlDriver")))
@protocol RawgSdkRuntimeSqlDriver <RawgSdkRuntimeCloseable>
@required
- (RawgSdkRuntimeTransacterTransaction * _Nullable)currentTransaction __attribute__((swift_name("currentTransaction()")));
- (void)executeIdentifier:(RawgSdkInt * _Nullable)identifier sql:(NSString *)sql parameters:(int32_t)parameters binders:(void (^ _Nullable)(id<RawgSdkRuntimeSqlPreparedStatement>))binders __attribute__((swift_name("execute(identifier:sql:parameters:binders:)")));
- (id<RawgSdkRuntimeSqlCursor>)executeQueryIdentifier:(RawgSdkInt * _Nullable)identifier sql:(NSString *)sql parameters:(int32_t)parameters binders:(void (^ _Nullable)(id<RawgSdkRuntimeSqlPreparedStatement>))binders __attribute__((swift_name("executeQuery(identifier:sql:parameters:binders:)")));
- (RawgSdkRuntimeTransacterTransaction *)doNewTransaction __attribute__((swift_name("doNewTransaction()")));
@end;

__attribute__((swift_name("RuntimeTransactionCallbacks")))
@protocol RawgSdkRuntimeTransactionCallbacks
@required
- (void)afterCommitFunction:(void (^)(void))function __attribute__((swift_name("afterCommit(function:)")));
- (void)afterRollbackFunction:(void (^)(void))function __attribute__((swift_name("afterRollback(function:)")));
@end;

__attribute__((swift_name("RuntimeTransactionWithoutReturn")))
@protocol RawgSdkRuntimeTransactionWithoutReturn <RawgSdkRuntimeTransactionCallbacks>
@required
- (void)rollback __attribute__((swift_name("rollback()")));
- (void)transactionBody:(void (^)(id<RawgSdkRuntimeTransactionWithoutReturn>))body __attribute__((swift_name("transaction(body:)")));
@end;

__attribute__((swift_name("RuntimeTransactionWithReturn")))
@protocol RawgSdkRuntimeTransactionWithReturn <RawgSdkRuntimeTransactionCallbacks>
@required
- (void)rollbackReturnValue:(id _Nullable)returnValue __attribute__((swift_name("rollback(returnValue:)")));
- (id _Nullable)transactionBody_:(id _Nullable (^)(id<RawgSdkRuntimeTransactionWithReturn>))body __attribute__((swift_name("transaction(body_:)")));
@end;

__attribute__((swift_name("RuntimeSqlDriverSchema")))
@protocol RawgSdkRuntimeSqlDriverSchema
@required
- (void)createDriver:(id<RawgSdkRuntimeSqlDriver>)driver __attribute__((swift_name("create(driver:)")));
- (void)migrateDriver:(id<RawgSdkRuntimeSqlDriver>)driver oldVersion:(int32_t)oldVersion newVersion:(int32_t)newVersion __attribute__((swift_name("migrate(driver:oldVersion:newVersion:)")));
@property (readonly) int32_t version __attribute__((swift_name("version")));
@end;

__attribute__((swift_name("RuntimeQuery")))
@interface RawgSdkRuntimeQuery<__covariant RowType> : RawgSdkBase
- (instancetype)initWithQueries:(NSMutableArray<RawgSdkRuntimeQuery<id> *> *)queries mapper:(RowType (^)(id<RawgSdkRuntimeSqlCursor>))mapper __attribute__((swift_name("init(queries:mapper:)"))) __attribute__((objc_designated_initializer));
- (void)addListenerListener:(id<RawgSdkRuntimeQueryListener>)listener __attribute__((swift_name("addListener(listener:)")));
- (id<RawgSdkRuntimeSqlCursor>)execute __attribute__((swift_name("execute()")));
- (NSArray<RowType> *)executeAsList __attribute__((swift_name("executeAsList()")));
- (RowType)executeAsOne __attribute__((swift_name("executeAsOne()")));
- (RowType _Nullable)executeAsOneOrNull __attribute__((swift_name("executeAsOneOrNull()")));
- (void)notifyDataChanged __attribute__((swift_name("notifyDataChanged()")));
- (void)removeListenerListener:(id<RawgSdkRuntimeQueryListener>)listener __attribute__((swift_name("removeListener(listener:)")));
@property (readonly) RowType (^mapper)(id<RawgSdkRuntimeSqlCursor>) __attribute__((swift_name("mapper")));
@end;

__attribute__((swift_name("KotlinRuntimeException")))
@interface RawgSdkKotlinRuntimeException : RawgSdkKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(RawgSdkKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(RawgSdkKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinIllegalStateException")))
@interface RawgSdkKotlinIllegalStateException : RawgSdkKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(RawgSdkKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(RawgSdkKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinCancellationException")))
@interface RawgSdkKotlinCancellationException : RawgSdkKotlinIllegalStateException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(RawgSdkKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(RawgSdkKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreFlow")))
@protocol RawgSdkKotlinx_coroutines_coreFlow
@required

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)collectCollector:(id<RawgSdkKotlinx_coroutines_coreFlowCollector>)collector completionHandler:(void (^)(RawgSdkKotlinUnit * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("collect(collector:completionHandler:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface RawgSdkKotlinArray<T> : RawgSdkBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(RawgSdkInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<RawgSdkKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreEncoder")))
@protocol RawgSdkKotlinx_serialization_coreEncoder
@required
- (id<RawgSdkKotlinx_serialization_coreCompositeEncoder>)beginCollectionDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor collectionSize:(int32_t)collectionSize __attribute__((swift_name("beginCollection(descriptor:collectionSize:)")));
- (id<RawgSdkKotlinx_serialization_coreCompositeEncoder>)beginCollectionDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor collectionSize:(int32_t)collectionSize typeSerializers:(RawgSdkKotlinArray<id<RawgSdkKotlinx_serialization_coreKSerializer>> *)typeSerializers __attribute__((swift_name("beginCollection(descriptor:collectionSize:typeSerializers:)"))) __attribute__((unavailable("Parameter typeSerializers is deprecated for removal. Please migrate to beginCollection method with two arguments.")));
- (id<RawgSdkKotlinx_serialization_coreCompositeEncoder>)beginStructureDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (id<RawgSdkKotlinx_serialization_coreCompositeEncoder>)beginStructureDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor typeSerializers:(RawgSdkKotlinArray<id<RawgSdkKotlinx_serialization_coreKSerializer>> *)typeSerializers __attribute__((swift_name("beginStructure(descriptor:typeSerializers:)"))) __attribute__((unavailable("Parameter typeSerializers is deprecated for removal. Please migrate to beginStructure method with one argument.")));
- (void)encodeBooleanValue:(BOOL)value __attribute__((swift_name("encodeBoolean(value:)")));
- (void)encodeByteValue:(int8_t)value __attribute__((swift_name("encodeByte(value:)")));
- (void)encodeCharValue:(unichar)value __attribute__((swift_name("encodeChar(value:)")));
- (void)encodeDoubleValue:(double)value __attribute__((swift_name("encodeDouble(value:)")));
- (void)encodeEnumEnumDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)enumDescriptor index:(int32_t)index __attribute__((swift_name("encodeEnum(enumDescriptor:index:)")));
- (void)encodeFloatValue:(float)value __attribute__((swift_name("encodeFloat(value:)")));
- (void)encodeIntValue:(int32_t)value __attribute__((swift_name("encodeInt(value:)")));
- (void)encodeLongValue:(int64_t)value __attribute__((swift_name("encodeLong(value:)")));
- (void)encodeNotNullMark __attribute__((swift_name("encodeNotNullMark()")));
- (void)encodeNull __attribute__((swift_name("encodeNull()")));
- (void)encodeNullableSerializableValueSerializer:(id<RawgSdkKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableValue(serializer:value:)")));
- (void)encodeSerializableValueSerializer:(id<RawgSdkKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableValue(serializer:value:)")));
- (void)encodeShortValue:(int16_t)value __attribute__((swift_name("encodeShort(value:)")));
- (void)encodeStringValue:(NSString *)value __attribute__((swift_name("encodeString(value:)")));
@property (readonly) RawgSdkKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerialDescriptor")))
@protocol RawgSdkKotlinx_serialization_coreSerialDescriptor
@required
- (NSArray<id<RawgSdkKotlinAnnotation>> *)getElementAnnotationsIndex:(int32_t)index __attribute__((swift_name("getElementAnnotations(index:)")));
- (id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)getElementDescriptorIndex:(int32_t)index __attribute__((swift_name("getElementDescriptor(index:)")));
- (int32_t)getElementIndexName:(NSString *)name __attribute__((swift_name("getElementIndex(name:)")));
- (NSString *)getElementNameIndex:(int32_t)index __attribute__((swift_name("getElementName(index:)")));
- (BOOL)isElementOptionalIndex:(int32_t)index __attribute__((swift_name("isElementOptional(index:)")));
@property (readonly) NSArray<id<RawgSdkKotlinAnnotation>> *annotations __attribute__((swift_name("annotations")));
@property (readonly) int32_t elementsCount __attribute__((swift_name("elementsCount")));
@property (readonly) BOOL isNullable __attribute__((swift_name("isNullable")));
@property (readonly) RawgSdkKotlinx_serialization_coreSerialKind *kind __attribute__((swift_name("kind")));
@property (readonly) NSString *serialName __attribute__((swift_name("serialName")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreDecoder")))
@protocol RawgSdkKotlinx_serialization_coreDecoder
@required
- (id<RawgSdkKotlinx_serialization_coreCompositeDecoder>)beginStructureDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (id<RawgSdkKotlinx_serialization_coreCompositeDecoder>)beginStructureDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor typeParams:(RawgSdkKotlinArray<id<RawgSdkKotlinx_serialization_coreKSerializer>> *)typeParams __attribute__((swift_name("beginStructure(descriptor:typeParams:)"))) __attribute__((unavailable("Parameter typeSerializers is deprecated for removal. Please migrate to beginStructure method with one argument.")));
- (BOOL)decodeBoolean __attribute__((swift_name("decodeBoolean()")));
- (int8_t)decodeByte __attribute__((swift_name("decodeByte()")));
- (unichar)decodeChar __attribute__((swift_name("decodeChar()")));
- (double)decodeDouble __attribute__((swift_name("decodeDouble()")));
- (int32_t)decodeEnumEnumDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)enumDescriptor __attribute__((swift_name("decodeEnum(enumDescriptor:)")));
- (float)decodeFloat __attribute__((swift_name("decodeFloat()")));
- (int32_t)decodeInt __attribute__((swift_name("decodeInt()")));
- (int64_t)decodeLong __attribute__((swift_name("decodeLong()")));
- (BOOL)decodeNotNullMark __attribute__((swift_name("decodeNotNullMark()")));
- (RawgSdkKotlinNothing * _Nullable)decodeNull __attribute__((swift_name("decodeNull()")));
- (id _Nullable)decodeNullableSerializableValueDeserializer:(id<RawgSdkKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeNullableSerializableValue(deserializer:)")));
- (id _Nullable)decodeSerializableValueDeserializer:(id<RawgSdkKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeSerializableValue(deserializer:)")));
- (int16_t)decodeShort __attribute__((swift_name("decodeShort()")));
- (NSString *)decodeString __attribute__((swift_name("decodeString()")));
- (id _Nullable)updateNullableSerializableValueDeserializer:(id<RawgSdkKotlinx_serialization_coreDeserializationStrategy>)deserializer old:(id _Nullable)old __attribute__((swift_name("updateNullableSerializableValue(deserializer:old:)"))) __attribute__((unavailable("Update* methods are deprecated for removal. Update behaviour is now considered an implementation detail of the format.Updating elements that are outside of structure is an unsupported operation.")));
- (id _Nullable)updateSerializableValueDeserializer:(id<RawgSdkKotlinx_serialization_coreDeserializationStrategy>)deserializer old:(id _Nullable)old __attribute__((swift_name("updateSerializableValue(deserializer:old:)"))) __attribute__((unavailable("Update* methods are deprecated for removal. Update behaviour is now considered an implementation detail of the format.Updating elements that are outside of structure is an unsupported operation.")));
@property (readonly) RawgSdkKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@property (readonly) RawgSdkKotlinx_serialization_coreUpdateMode *updateMode __attribute__((swift_name("updateMode"))) __attribute__((unavailable("Update mode in Decoder is deprecated for removal. Update behaviour is now considered an implementation detail of the format that should not concern serializer.")));
@end;

__attribute__((swift_name("RuntimeTransacterTransaction")))
@interface RawgSdkRuntimeTransacterTransaction : RawgSdkBase <RawgSdkRuntimeTransactionCallbacks>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)afterCommitFunction:(void (^)(void))function __attribute__((swift_name("afterCommit(function:)")));
- (void)afterRollbackFunction:(void (^)(void))function __attribute__((swift_name("afterRollback(function:)")));
- (void)endTransactionSuccessful:(BOOL)successful __attribute__((swift_name("endTransaction(successful:)")));
@property (readonly) RawgSdkRuntimeTransacterTransaction * _Nullable enclosingTransaction __attribute__((swift_name("enclosingTransaction")));
@end;

__attribute__((swift_name("RuntimeSqlPreparedStatement")))
@protocol RawgSdkRuntimeSqlPreparedStatement
@required
- (void)bindBytesIndex:(int32_t)index value:(RawgSdkKotlinByteArray * _Nullable)value __attribute__((swift_name("bindBytes(index:value:)")));
- (void)bindDoubleIndex:(int32_t)index value:(RawgSdkDouble * _Nullable)value __attribute__((swift_name("bindDouble(index:value:)")));
- (void)bindLongIndex:(int32_t)index value:(RawgSdkLong * _Nullable)value __attribute__((swift_name("bindLong(index:value:)")));
- (void)bindStringIndex:(int32_t)index value:(NSString * _Nullable)value __attribute__((swift_name("bindString(index:value:)")));
@end;

__attribute__((swift_name("RuntimeSqlCursor")))
@protocol RawgSdkRuntimeSqlCursor <RawgSdkRuntimeCloseable>
@required
- (RawgSdkKotlinByteArray * _Nullable)getBytesIndex:(int32_t)index __attribute__((swift_name("getBytes(index:)")));
- (RawgSdkDouble * _Nullable)getDoubleIndex:(int32_t)index __attribute__((swift_name("getDouble(index:)")));
- (RawgSdkLong * _Nullable)getLongIndex:(int32_t)index __attribute__((swift_name("getLong(index:)")));
- (NSString * _Nullable)getStringIndex:(int32_t)index __attribute__((swift_name("getString(index:)")));
- (BOOL)next __attribute__((swift_name("next()")));
@end;

__attribute__((swift_name("RuntimeQueryListener")))
@protocol RawgSdkRuntimeQueryListener
@required
- (void)queryResultsChanged __attribute__((swift_name("queryResultsChanged()")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreFlowCollector")))
@protocol RawgSdkKotlinx_coroutines_coreFlowCollector
@required

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)emitValue:(id _Nullable)value completionHandler:(void (^)(RawgSdkKotlinUnit * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("emit(value:completionHandler:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinUnit")))
@interface RawgSdkKotlinUnit : RawgSdkBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)unit __attribute__((swift_name("init()")));
- (NSString *)description __attribute__((swift_name("description()")));
@end;

__attribute__((swift_name("KotlinIterator")))
@protocol RawgSdkKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next_ __attribute__((swift_name("next_()")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreCompositeEncoder")))
@protocol RawgSdkKotlinx_serialization_coreCompositeEncoder
@required
- (void)encodeBooleanElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(BOOL)value __attribute__((swift_name("encodeBooleanElement(descriptor:index:value:)")));
- (void)encodeByteElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int8_t)value __attribute__((swift_name("encodeByteElement(descriptor:index:value:)")));
- (void)encodeCharElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(unichar)value __attribute__((swift_name("encodeCharElement(descriptor:index:value:)")));
- (void)encodeDoubleElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(double)value __attribute__((swift_name("encodeDoubleElement(descriptor:index:value:)")));
- (void)encodeFloatElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(float)value __attribute__((swift_name("encodeFloatElement(descriptor:index:value:)")));
- (void)encodeIntElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int32_t)value __attribute__((swift_name("encodeIntElement(descriptor:index:value:)")));
- (void)encodeLongElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int64_t)value __attribute__((swift_name("encodeLongElement(descriptor:index:value:)")));
- (void)encodeNonSerializableElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(id)value __attribute__((swift_name("encodeNonSerializableElement(descriptor:index:value:)"))) __attribute__((unavailable("This method is deprecated for removal. Please remove it from your implementation and delegate to default method instead")));
- (void)encodeNullableSerializableElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<RawgSdkKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeSerializableElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<RawgSdkKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeShortElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int16_t)value __attribute__((swift_name("encodeShortElement(descriptor:index:value:)")));
- (void)encodeStringElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(NSString *)value __attribute__((swift_name("encodeStringElement(descriptor:index:value:)")));
- (void)endStructureDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));
- (BOOL)shouldEncodeElementDefaultDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("shouldEncodeElementDefault(descriptor:index:)")));
@property (readonly) RawgSdkKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerializersModule")))
@interface RawgSdkKotlinx_serialization_coreSerializersModule : RawgSdkBase
- (void)dumpToCollector:(id<RawgSdkKotlinx_serialization_coreSerializersModuleCollector>)collector __attribute__((swift_name("dumpTo(collector:)")));
- (id<RawgSdkKotlinx_serialization_coreKSerializer> _Nullable)getContextualKclass:(id<RawgSdkKotlinKClass>)kclass __attribute__((swift_name("getContextual(kclass:)")));
- (id<RawgSdkKotlinx_serialization_coreSerializationStrategy> _Nullable)getPolymorphicBaseClass:(id<RawgSdkKotlinKClass>)baseClass value:(id)value __attribute__((swift_name("getPolymorphic(baseClass:value:)")));
- (id<RawgSdkKotlinx_serialization_coreDeserializationStrategy> _Nullable)getPolymorphicBaseClass:(id<RawgSdkKotlinKClass>)baseClass serializedClassName:(NSString * _Nullable)serializedClassName __attribute__((swift_name("getPolymorphic(baseClass:serializedClassName:)")));
@end;

__attribute__((swift_name("KotlinAnnotation")))
@protocol RawgSdkKotlinAnnotation
@required
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerialKind")))
@interface RawgSdkKotlinx_serialization_coreSerialKind : RawgSdkBase
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreCompositeDecoder")))
@protocol RawgSdkKotlinx_serialization_coreCompositeDecoder
@required
- (BOOL)decodeBooleanElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeBooleanElement(descriptor:index:)")));
- (int8_t)decodeByteElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeByteElement(descriptor:index:)")));
- (unichar)decodeCharElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeCharElement(descriptor:index:)")));
- (int32_t)decodeCollectionSizeDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeCollectionSize(descriptor:)")));
- (double)decodeDoubleElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeDoubleElement(descriptor:index:)")));
- (int32_t)decodeElementIndexDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeElementIndex(descriptor:)")));
- (float)decodeFloatElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeFloatElement(descriptor:index:)")));
- (int32_t)decodeIntElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeIntElement(descriptor:index:)")));
- (int64_t)decodeLongElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeLongElement(descriptor:index:)")));
- (id _Nullable)decodeNullableSerializableElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor i:(int32_t)i deserializer:(id<RawgSdkKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeNullableSerializableElement(descriptor:i:deserializer:)"))) __attribute__((unavailable("Please migrate to decodeElement method which accepts old value.Feel free to ignore it if your format does not support updates.")));
- (id _Nullable)decodeNullableSerializableElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<RawgSdkKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeNullableSerializableElement(descriptor:index:deserializer:previousValue:)")));
- (BOOL)decodeSequentially __attribute__((swift_name("decodeSequentially()")));
- (id _Nullable)decodeSerializableElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor i:(int32_t)i deserializer:(id<RawgSdkKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeSerializableElement(descriptor:i:deserializer:)"))) __attribute__((unavailable("Please migrate to decodeElement method which accepts old value.Feel free to ignore it if your format does not support updates.")));
- (id _Nullable)decodeSerializableElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<RawgSdkKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeSerializableElement(descriptor:index:deserializer:previousValue:)")));
- (int16_t)decodeShortElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeShortElement(descriptor:index:)")));
- (NSString *)decodeStringElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeStringElement(descriptor:index:)")));
- (void)endStructureDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));
- (id _Nullable)updateNullableSerializableElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<RawgSdkKotlinx_serialization_coreDeserializationStrategy>)deserializer old:(id _Nullable)old __attribute__((swift_name("updateNullableSerializableElement(descriptor:index:deserializer:old:)"))) __attribute__((unavailable("Update* methods are deprecated for removal. Update behaviour is now considered an implementation detail of the format.Pass the old value to decodeSerializable*, so formats that support update could use it.")));
- (id _Nullable)updateSerializableElementDescriptor:(id<RawgSdkKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<RawgSdkKotlinx_serialization_coreDeserializationStrategy>)deserializer old:(id _Nullable)old __attribute__((swift_name("updateSerializableElement(descriptor:index:deserializer:old:)"))) __attribute__((unavailable("Update* methods are deprecated for removal. Update behaviour is now considered an implementation detail of the format.Pass the old value to decodeSerializable*, so formats that support update could use it.")));
@property (readonly) RawgSdkKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@property (readonly) RawgSdkKotlinx_serialization_coreUpdateMode *updateMode __attribute__((swift_name("updateMode"))) __attribute__((unavailable("Update mode in Decoder is deprecated for removal. Update behaviour is now considered an implementation detail of the format that should not concern serializer.")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinNothing")))
@interface RawgSdkKotlinNothing : RawgSdkBase
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_serialization_coreUpdateMode")))
@interface RawgSdkKotlinx_serialization_coreUpdateMode : RawgSdkKotlinEnum<RawgSdkKotlinx_serialization_coreUpdateMode *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) RawgSdkKotlinx_serialization_coreUpdateMode *banned __attribute__((swift_name("banned")));
@property (class, readonly) RawgSdkKotlinx_serialization_coreUpdateMode *overwrite __attribute__((swift_name("overwrite")));
@property (class, readonly) RawgSdkKotlinx_serialization_coreUpdateMode *update __attribute__((swift_name("update")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinByteArray")))
@interface RawgSdkKotlinByteArray : RawgSdkBase
+ (instancetype)arrayWithSize:(int32_t)size __attribute__((swift_name("init(size:)")));
+ (instancetype)arrayWithSize:(int32_t)size init:(RawgSdkByte *(^)(RawgSdkInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (int8_t)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (RawgSdkKotlinByteIterator *)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(int8_t)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerializersModuleCollector")))
@protocol RawgSdkKotlinx_serialization_coreSerializersModuleCollector
@required
- (void)contextualKClass:(id<RawgSdkKotlinKClass>)kClass serializer:(id<RawgSdkKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("contextual(kClass:serializer:)")));
- (void)polymorphicBaseClass:(id<RawgSdkKotlinKClass>)baseClass actualClass:(id<RawgSdkKotlinKClass>)actualClass actualSerializer:(id<RawgSdkKotlinx_serialization_coreKSerializer>)actualSerializer __attribute__((swift_name("polymorphic(baseClass:actualClass:actualSerializer:)")));
- (void)polymorphicDefaultBaseClass:(id<RawgSdkKotlinKClass>)baseClass defaultSerializerProvider:(id<RawgSdkKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable))defaultSerializerProvider __attribute__((swift_name("polymorphicDefault(baseClass:defaultSerializerProvider:)")));
@end;

__attribute__((swift_name("KotlinKDeclarationContainer")))
@protocol RawgSdkKotlinKDeclarationContainer
@required
@end;

__attribute__((swift_name("KotlinKAnnotatedElement")))
@protocol RawgSdkKotlinKAnnotatedElement
@required
@end;

__attribute__((swift_name("KotlinKClassifier")))
@protocol RawgSdkKotlinKClassifier
@required
@end;

__attribute__((swift_name("KotlinKClass")))
@protocol RawgSdkKotlinKClass <RawgSdkKotlinKDeclarationContainer, RawgSdkKotlinKAnnotatedElement, RawgSdkKotlinKClassifier>
@required
- (BOOL)isInstanceValue:(id _Nullable)value __attribute__((swift_name("isInstance(value:)")));
@property (readonly) NSString * _Nullable qualifiedName __attribute__((swift_name("qualifiedName")));
@property (readonly) NSString * _Nullable simpleName __attribute__((swift_name("simpleName")));
@end;

__attribute__((swift_name("KotlinByteIterator")))
@interface RawgSdkKotlinByteIterator : RawgSdkBase <RawgSdkKotlinIterator>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (RawgSdkByte *)next_ __attribute__((swift_name("next_()")));
- (int8_t)nextByte __attribute__((swift_name("nextByte()")));
@end;

#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END
