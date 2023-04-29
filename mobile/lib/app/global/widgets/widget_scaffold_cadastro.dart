import 'package:app/app/global/widgets/widget_scaffold.dart';
import 'package:flutter/material.dart';

class DwScaffoldCadastro extends StatelessWidget {
  final String title;
  final GlobalKey chave;
  final Widget body;
  final Widget floatingActionButton;

  const DwScaffoldCadastro({
    Key key,
    this.title,
    this.chave,
    this.body,
    this.floatingActionButton,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return DwScaffold(
      key: chave,
      title: this.title,
      body: SingleChildScrollView(child: body),
      floatingActionButton: floatingActionButton,
    );
  }
}
