import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/providers/daily_devotional_service_provider.dart';

final dailyDevotionalTodayProvider = FutureProvider.autoDispose<String>((ref) {
  ref.maintainState = true;

  return ref.read(dailyDevotionalServiceProvider).todaysDailyDevotional;
});
