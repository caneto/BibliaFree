import 'package:dio/dio.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/services/verse_of_the_day_service.dart';

final verseOfTheDayServiceProvider = Provider<VerseOfTheDayService>((ref) {
  return VerseOfTheDayService(Dio());
});
