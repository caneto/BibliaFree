
import 'dart:io';


var homeViewBannerAdIsLoaded = false;
var churchViewBannerAdIsLoaded = false;
var votdViewBannerAdIsLoaded = false;

class AdState {
  // iOS ad ids
  static const _iosHomeViewBannerAdId = 'ca-app-pub-6026970342993334/4798379037';
  static const _iosChurchViewBannerAdId = 'ca-app-pub-6026970342993334/8562928877';
  static const _iosVotdViewBannerAdId = 'ca-app-pub-6026970342993334/4452474650';

  // Android ad ids
  static const _androidHomeViewBannerAdId = 'ca-app-pub-6026970342993334/8364189149';
  static const _androidChurchViewBannerAdId = 'ca-app-pub-6026970342993334/6049936860';
  static const _androidVotdViewBannerAdId = 'ca-app-pub-6026970342993334/2331037330';

  String get homeViewbannerAdUnitId {
    if (Platform.isAndroid) {
      return _androidHomeViewBannerAdId;
    } else {
      return _iosHomeViewBannerAdId;
    }
  }

  String get churchViewbannerAdUnitId {
    if (Platform.isAndroid) {
      return _androidChurchViewBannerAdId;
    } else {
      return _iosChurchViewBannerAdId;
    }
  }

  String get votdViewbannerAdUnitId {
    if (Platform.isAndroid) {
      return _androidVotdViewBannerAdId;
    } else {
      return _iosVotdViewBannerAdId;
    }
  }

}
