import 'package:dio/dio.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/services/daily_devotional_service.dart';

final dailyDevotionalServiceProvider = Provider<DailyDevotionalService>((ref) {
  return DailyDevotionalService(Dio());
});
