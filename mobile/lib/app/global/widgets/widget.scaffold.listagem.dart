import 'package:app/app/global/widgets/widget_scaffold.dart';
import 'package:flutter/material.dart';

class DwScaffoldListagem extends StatelessWidget {
  final String title;
  final GlobalKey chave;
  final Widget body;
  final Widget floatingActionButton;

  const DwScaffoldListagem({
    Key key,
    this.title,
    this.chave,
    this.body,
    this.floatingActionButton,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return DwScaffold(
      key: this.chave,
      title: this.title,
      body: Center(child: this.body),
      floatingActionButton: this.floatingActionButton,
    );
  }
}
