import 'package:canton_ui/canton_ui.dart';
import 'package:firebase_analytics/firebase_analytics.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:bibliafree/src/config/bottom_navigation_bar.dart';
import 'package:bibliafree/src/providers/last_translation_book_chapter_provider.dart';
import 'package:bibliafree/src/providers/reader_settings_repository_provider.dart';
import 'package:bibliafree/src/providers/streaks_repository_provider.dart';
import 'package:bibliafree/src/providers/study_tools_repository_provider.dart';
import 'package:bibliafree/src/ui/views/bible_view/bible_view.dart';
import 'package:bibliafree/src/ui/views/church_view/church_view.dart';
import 'package:bibliafree/src/ui/views/home_view/home_view.dart';
import 'package:bibliafree/src/ui/views/profile_view/profile_view.dart';

final _homeNavigatorKey = GlobalKey<NavigatorState>();
final _bibleNavigatorKey = GlobalKey<NavigatorState>();
final _churchNavigatorKey = GlobalKey<NavigatorState>();
final _profileNavigatorKey = GlobalKey<NavigatorState>();

class CurrentView extends ConsumerStatefulWidget {
  const CurrentView({Key? key}) : super(key: key);

  @override
  _CurrentViewState createState() => _CurrentViewState();
}

class _CurrentViewState extends ConsumerState<CurrentView> {
  int _currentIndex = 0;

  @override
  void initState() {
    super.initState();
    _loadData();
  }

  void _onTabTapped(int index) {
    if (index == _currentIndex && _currentIndex == 0 && _homeNavigatorKey.currentState!.canPop()) {
      _homeNavigatorKey.currentState!.pop();
    }
    if (index == _currentIndex && _currentIndex == 1 && _bibleNavigatorKey.currentState!.canPop()) {
      _bibleNavigatorKey.currentState!.pop();
    }
    if (index == _currentIndex && _currentIndex == 2 && _churchNavigatorKey.currentState!.canPop()) {
      _churchNavigatorKey.currentState!.pop();
    }
    if (index == _currentIndex && _currentIndex == 3 && _profileNavigatorKey.currentState!.canPop()) {
      _profileNavigatorKey.currentState!.pop();
    }

    setState(() {
      _currentIndex = index;
    });
  }

  void _loadData() async {
    await ref.read(streaksRepositoryProvider).updateStreaks();
    ref.read(localRepositoryProvider.notifier).loadLastChapterAndTranslation();
    ref.read(studyToolsRepositoryProvider.notifier).loadData();
    ref.read(readerSettingsRepositoryProvider).loadData();
  }

  @override
  Widget build(BuildContext context) {
    const _views = <Widget>[
      HomeView(),
      BibleView(),
      ChurchView(),
      ProfileView(),
    ];

    return CantonScaffold(
      safeArea: false,
      bottomNavBar: BottomNavBar(_currentIndex, _onTabTapped),
      resizeToAvoidBottomInset: true,
      padding: EdgeInsets.zero,
      backgroundColor: CantonMethods.alternateCanvasColor(context, index: _currentIndex, targetIndexes: [1]),
      body: IndexedStack(
        index: _currentIndex,
        children: [
          Navigator(
            key: _homeNavigatorKey,
            observers: [FirebaseAnalyticsObserver(analytics: FirebaseAnalytics.instance)],
            onGenerateRoute: (settings) {
              return MaterialPageRoute(
                settings: settings,
                fullscreenDialog: true,
                builder: (context) {
                  return SafeArea(
                    child: Container(
                      padding: const EdgeInsets.symmetric(horizontal: 17),
                      child: SafeArea(child: _views[_currentIndex]),
                    ),
                  );
                },
              );
            },
          ),
          Navigator(
            key: _bibleNavigatorKey,
            observers: [FirebaseAnalyticsObserver(analytics: FirebaseAnalytics.instance)],
            onGenerateRoute: (settings) {
              return MaterialPageRoute(
                settings: settings,
                fullscreenDialog: true,
                builder: (context) => SafeArea(child: _views[_currentIndex]),
              );
            },
          ),
          Navigator(
            key: _churchNavigatorKey,
            observers: [FirebaseAnalyticsObserver(analytics: FirebaseAnalytics.instance)],
            onGenerateRoute: (settings) {
              return MaterialPageRoute(
                settings: settings,
                fullscreenDialog: true,
                builder: (context) => SafeArea(
                  child: Container(
                    padding: const EdgeInsets.symmetric(horizontal: 17),
                    child: _views[_currentIndex],
                  ),
                ),
              );
            },
          ),
          Navigator(
            key: _profileNavigatorKey,
            observers: [FirebaseAnalyticsObserver(analytics: FirebaseAnalytics.instance)],
            onGenerateRoute: (settings) {
              return MaterialPageRoute(
                settings: settings,
                fullscreenDialog: true,
                builder: (context) => SafeArea(child: _views[_currentIndex]),
              );
            },
          ),
        ],
      ),
    );
  }
}
