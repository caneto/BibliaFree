import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/services/daily_readings_service.dart';

final dailyReadingsServiceProvider = Provider<DailyReadingsService>((ref) {
  return DailyReadingsService();
});
