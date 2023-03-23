import 'package:canton_ui/canton_ui.dart';
import 'package:bibliafree/src/ui/views/settings_view/components/reader_settings_card.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/config/constants.dart';
import 'package:bibliafree/src/ui/views/settings_view/components/change_birth_date_card.dart';
import 'package:bibliafree/src/ui/views/settings_view/components/change_first_name_card.dart';
import 'package:bibliafree/src/ui/views/settings_view/components/change_last_name_card.dart';
import 'package:bibliafree/src/ui/views/settings_view/components/settings_view_header.dart';

class SettingsView extends ConsumerWidget {
  const SettingsView({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return CantonScaffoldType2(
      backgroundColor: Theme.of(context).canvasColor,
      body: _content(context),
    );
  }

  Widget _content(BuildContext context) {
    return SingleChildScrollView(
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          const SettingsViewHeader(),
          const SizedBox(height: 17),
          ConstrainedBox(
            constraints: const BoxConstraints(maxWidth: 500),
            child: const ChangeFirstNameCard(),
          ),
          ConstrainedBox(
            constraints: const BoxConstraints(maxWidth: 500),
            child: const Padding(padding: EdgeInsets.symmetric(horizontal: 17), child: Divider()),
          ),
          ConstrainedBox(
            constraints: const BoxConstraints(maxWidth: 500),
            child: const ChangeLastNameCard(),
          ),
          ConstrainedBox(
            constraints: const BoxConstraints(maxWidth: 500),
            child: const Padding(padding: EdgeInsets.symmetric(horizontal: 17), child: Divider()),
          ),
          ConstrainedBox(
            constraints: const BoxConstraints(maxWidth: 500),
            child: const ChangeBirthDateCard(),
          ),
          const SizedBox(height: kDefaultPadding),
          ConstrainedBox(
            constraints: const BoxConstraints(maxWidth: 500),
            child: const ReaderSettingsCard(),
          ),
          const SizedBox(height: kSmallPadding),
          Text(
            kVersionNumber,
            style: Theme.of(context).textTheme.bodyMedium?.copyWith(
                  fontWeight: FontWeight.w500,
                ),
          ),
        ],
      ),
    );
  }
}
