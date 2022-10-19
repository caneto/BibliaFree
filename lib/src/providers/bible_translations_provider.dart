import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/models/translation.dart';
import 'package:bibliafree/src/providers/bible_repository_provider.dart';

String translationID = '';

final bibleTranslationsProvider = Provider<List<Translation>>((ref) {
  final bibleService = ref.watch(bibleRepositoryProvider);
  final versions = bibleService.translations;

  return versions;
});
