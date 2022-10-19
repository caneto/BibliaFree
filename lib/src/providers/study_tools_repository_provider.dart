import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/repositories/study_tools_repository.dart';

final studyToolsRepositoryProvider = ChangeNotifierProvider<StudyToolsRepository>((ref) {
  return StudyToolsRepository();
});
