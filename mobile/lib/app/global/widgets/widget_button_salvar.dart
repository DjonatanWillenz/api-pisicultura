import 'package:app/app/global/widgets/widget_button.dart';
import 'package:flutter/material.dart';

class DwButtonSalvar extends StatelessWidget {
  final Function funOnTap;

  const DwButtonSalvar({Key key, this.funOnTap}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return DwButton(
      funOnTap: this.funOnTap,
      cor: Colors.green,
      label: "Salvar",
      icon: Icons.save_alt_rounded,
    );
  }
}
