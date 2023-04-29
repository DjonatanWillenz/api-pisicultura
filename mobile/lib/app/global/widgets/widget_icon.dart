import 'package:flutter/material.dart';

class DwIcon extends StatelessWidget {
  final IconData icon;
  final double size;

  const DwIcon({Key key, @required this.icon, this.size = 23})
      : super(key: key);
  @override
  Widget build(BuildContext context) {
    return Container(
      child: Center(
        child: Icon(
          icon,
          size: size,
        ),
      ),
    );
  }
}
