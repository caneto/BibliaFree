import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/models/verse.dart';
import 'package:bibliafree/src/providers/verse_of_the_day_service_provider.dart';

final verseOfTheDayFutureProvider = FutureProvider.autoDispose<List<Verse>>((ref) {
  ref.maintainState = true;

  return ref.watch(verseOfTheDayServiceProvider).getVerseOfTheDay;
});
