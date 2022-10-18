import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/repositories/bible_repository.dart';

final bibleRepositoryProvider = Provider<BibleRepository>((ref) {
  return BibleRepository();
});
