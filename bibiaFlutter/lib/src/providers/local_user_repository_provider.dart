import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/repositories/local_user_repository.dart';

final localUserRepositoryProvider = ChangeNotifierProvider<LocalUserRepository>((ref) {
  return LocalUserRepository();
});
