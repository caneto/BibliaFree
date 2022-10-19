import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/providers/youtube_service_provider.dart';

final youtubeFetchLatestChurchVideoFutureProvider = FutureProvider<List<dynamic>>((ref) {
  return ref.read(youtubeServiceProvider).fetchLatestChurchVideoId();
});
