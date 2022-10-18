import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:elisha/src/providers/ad_state_provider.dart';
import 'package:elisha/src/services/ad_state.dart';
import 'package:elisha/src/ui/components/sunday_mass_card.dart';
import 'package:elisha/src/ui/views/church_view/components/church_view_header.dart';
import 'package:elisha/src/ui/views/church_view/components/daily_readings_card.dart';

class ChurchView extends ConsumerStatefulWidget {
  const ChurchView({Key? key}) : super(key: key);

  @override
  _ChurchViewState createState() => _ChurchViewState();
}

class _ChurchViewState extends ConsumerState<ChurchView> {

  @override
  Widget build(BuildContext context) {
    return _content(context);
  }

  Widget _content(BuildContext context) {
    return SingleChildScrollView(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          const ChurchViewHeader(),
          ConstrainedBox(
            constraints: const BoxConstraints(maxWidth: 500),
            child: const DailyReadingsCard(),
          ),
          const SizedBox(height: 20),
          ConstrainedBox(
            constraints: const BoxConstraints(maxWidth: 500),
            child: const SundayMassCard(),
          ),
          const SizedBox(height: 20),
        ],
      ),
    );
  }
}
