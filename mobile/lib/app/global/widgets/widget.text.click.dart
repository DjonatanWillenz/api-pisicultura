import 'package:flutter/material.dart';

class DwTextClick extends StatelessWidget {
  final String lbl;
  final double fontSize;
  final Color cor;
  final Function fun;

  const DwTextClick({
    Key key,
    @required this.lbl,
    this.fontSize = 24,
    this.cor = Colors.green,
    @required this.fun,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () => fun(),
      child: Center(
        child: Padding(
          padding: const EdgeInsets.all(3.0),
          child: Text(
            lbl,
            style: TextStyle(
              fontSize: this.fontSize,
              color: cor,
            ),
          ),
        ),
      ),
    );
  }
}
