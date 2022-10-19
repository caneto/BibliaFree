import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/models/translation_book_chapter.dart';
import 'package:bibliafree/src/repositories/last_translation_book_chapter_repository.dart';

final localRepositoryProvider =
    StateNotifierProvider<LastTranslationBookChapterRepository, TranslationBookChapter>((ref) {
  return LastTranslationBookChapterRepository();
});
