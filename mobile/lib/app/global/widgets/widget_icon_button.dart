import 'package:flutter/material.dart';

class DwIconButton extends StatelessWidget {
  final IconData icon;
  final Function onPressed;
  final Color corIcon;
  final double sizeIcon;
  final Color corBorda;

  const DwIconButton({
    Key key,
    this.corBorda = Colors.white,
    this.icon = Icons.ac_unit,
    @required this.onPressed,
    this.sizeIcon = 15,
    this.corIcon = Colors.white,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return IconButton(
      icon: Icon(
        icon,
        color: corIcon,
        size: sizeIcon,
      ),
      splashColor: corBorda,
      onPressed: onPressed,
    );
  }
}
