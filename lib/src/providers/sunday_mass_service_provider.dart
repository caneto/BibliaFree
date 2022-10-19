import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/services/sunday_mass_service.dart';

final sundayMassServiceProvider = Provider<SundayMassService>((ref) {
  return SundayMassService();
});
