import 'package:riverpod/riverpod.dart';

import 'package:bibliafree/src/services/bible_service.dart';

final bibleServiceProvider = Provider<BibleService>((ref) {
  return BibleService();
});
