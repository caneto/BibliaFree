import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/repositories/streaks_repository.dart';

final streaksRepositoryProvider = ChangeNotifierProvider<StreaksRepository>((ref) {
  return StreaksRepository();
});
