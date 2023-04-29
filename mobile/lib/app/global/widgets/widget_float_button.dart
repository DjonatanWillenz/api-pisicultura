import 'package:flutter/material.dart';

class DwFloatButtonRota extends StatelessWidget {
  final String routeName;

  const DwFloatButtonRota({
    Key key,
    @required this.routeName,
    String rotaOnPress,
    IconData icon,
    String subLabel,
    String label,
    Function() fun,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return FloatingActionButton(
      onPressed: () => Navigator.of(context).pushNamed(this.routeName),
      child: Icon(
        Icons.add,
        size: 45,
      ),
    );
  }
}
