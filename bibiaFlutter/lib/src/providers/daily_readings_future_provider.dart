import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/models/daily_reading.dart';
import 'package:bibliafree/src/services/daily_readings_service.dart';

final dailyReadingsFutureProvider = FutureProvider.autoDispose<DailyReading>((ref) {
  ref.maintainState = true;

  return DailyReadingsService().getTodaysReading;
});
