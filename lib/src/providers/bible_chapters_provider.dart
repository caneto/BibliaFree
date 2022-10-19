import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/models/chapter.dart';
import 'package:bibliafree/src/providers/bible_books_provider.dart';
import 'package:bibliafree/src/providers/bible_service_provider.dart';

String chapterID = '';
String translationAbb = '';

final bibleChaptersProvider = FutureProvider.autoDispose<Chapter>((ref) {
  ref.maintainState = true;

  final bibleService = ref.watch(bibleServiceProvider);
  final chapters = bibleService.getChapter(bookID, chapterID, translationAbb);

  return chapters;
});
