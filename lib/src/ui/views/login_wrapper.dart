import 'dart:io';

import 'package:canton_ui/canton_ui.dart';
import 'package:flutter/services.dart';

import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/providers/local_user_repository_provider.dart';
import 'package:bibliafree/src/ui/views/current_view.dart';
import 'package:bibliafree/src/ui/views/introduction_view/introduction_view.dart';

class LoginWrapper extends ConsumerStatefulWidget {
  const LoginWrapper({Key key}) : super(key: key);

  @override
  ConsumerState<LoginWrapper> createState() => _LoginWrapperState();
}

class _LoginWrapperState extends ConsumerState<LoginWrapper> {
  @override
  void initState() {
    super.initState();
    ref.read(localUserRepositoryProvider).loadUser();
  }

  @override
  Widget build(BuildContext context) {
    final count = ref.read(localUserRepositoryProvider).getLoginCount;

    final isDarkMode = MediaQuery.of(context).platformBrightness == Brightness.dark;

    Color statusBarColor() {
      if (Platform.isIOS) {
        return isDarkMode ? CantonColors.white : CantonColors.black;
      } else {
        return isDarkMode ? CantonColors.gray[900] : CantonColors.white;
      }
    }

    SystemChrome.setSystemUIOverlayStyle(
      SystemUiOverlayStyle.dark.copyWith(
        statusBarColor: statusBarColor(),
        statusBarBrightness: isDarkMode ? Brightness.dark : Brightness.light,
      ),
    );

    if (count > 1) {
      return const CurrentView();
    }

    return const IntroductionView();
  }
}
