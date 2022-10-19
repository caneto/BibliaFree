import 'package:canton_ui/canton_ui.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:line_awesome_flutter/line_awesome_flutter.dart';

class BottomNavBar extends ConsumerStatefulWidget {
  final int currentIndex;
  final void Function(int) onTabTapped;

  const BottomNavBar(this.currentIndex, this.onTabTapped, {Key? key}) : super(key: key);
  @override
  _BottomNavBarState createState() => _BottomNavBarState();
}

class _BottomNavBarState extends ConsumerState<BottomNavBar> {
  static const _iconSize = 27.0;

  @override
  Widget build(BuildContext context) {
    return BottomNavigationBar(
      currentIndex: widget.currentIndex,
      onTap: widget.onTabTapped,
      backgroundColor: Theme.of(context).colorScheme.secondary,
      selectedItemColor: Theme.of(context).colorScheme.primary,
      unselectedItemColor: Theme.of(context).colorScheme.secondaryVariant,
      selectedIconTheme: IconThemeData(color: Theme.of(context).primaryColor, size: 24),
      items: const [
        BottomNavigationBarItem(
          label: 'Casa',
          tooltip: '',
          activeIcon: Icon(LineAwesomeIcons.home, size: _iconSize),
          icon: Icon(LineAwesomeIcons.home, size: _iconSize),
        ),
        BottomNavigationBarItem(
          label: 'Bibla',
          tooltip: '',
          activeIcon: Icon(LineAwesomeIcons.bible, size: _iconSize),
          icon: Icon(LineAwesomeIcons.bible, size: _iconSize),
        ),
        BottomNavigationBarItem(
          label: 'Templo',
          tooltip: '',
          activeIcon: Icon(LineAwesomeIcons.church, size: _iconSize),
          icon: Icon(LineAwesomeIcons.church, size: _iconSize),
        ),
        BottomNavigationBarItem(
          label: 'Eu',
          tooltip: '',
          activeIcon: Icon(LineAwesomeIcons.user, size: _iconSize),
          icon: Icon(LineAwesomeIcons.user, size: _iconSize),
        ),
      ],
    );
  }
}
