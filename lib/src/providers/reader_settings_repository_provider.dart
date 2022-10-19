import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/repositories/reader_settings_repository.dart';

final readerSettingsRepositoryProvider = ChangeNotifierProvider<ReaderSettingsRepository>((ref) {
  return ReaderSettingsRepository();
});
