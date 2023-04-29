import 'package:flutter/material.dart';

class DwText extends StatelessWidget {
  final String lbl;
  final double fontSize;
  final Color cor;
  final FontStyle fontStyle;

  const DwText({
    Key key,
    @required this.lbl,
    this.fontSize = 18,
    this.cor = Colors.black,
    this.fontStyle = FontStyle.italic,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Padding(
        padding: const EdgeInsets.only(right: 0),
        child: Text(
          lbl,
          style: TextStyle(
            fontSize: this.fontSize,
            fontWeight: FontWeight.bold,
            color: cor,
            fontStyle: fontStyle,
          ),
        ),
      ),
    );
  }
}
