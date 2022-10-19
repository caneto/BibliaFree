import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/models/book.dart';
import 'package:bibliafree/src/providers/bible_service_provider.dart';

String bookID = '';

final bibleBooksProvider = FutureProvider.autoDispose<List<Book>>((ref) async {
  ref.maintainState = true;

  final bibleService = ref.watch(bibleServiceProvider);
  final books = bibleService.getBooks(bookID);

  return books;
});
