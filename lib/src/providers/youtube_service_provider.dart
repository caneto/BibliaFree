import 'package:dio/dio.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/services/youtube_service.dart';

final youtubeServiceProvider = Provider<YouTubeService>((ref) {
  return YouTubeService(Dio());
});
