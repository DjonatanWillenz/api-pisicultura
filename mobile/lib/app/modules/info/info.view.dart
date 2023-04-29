import 'package:app/app/global/utils/constantes.text.dart';
import 'package:app/app/global/widgets/widget_scaffold.dart';
import 'package:app/app/modules/info/info.controller.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

class InfoPage extends GetView<InfoController> {
  @override
  Widget build(BuildContext context) {
    return DwScaffold(
      title: UtilsTextLabels.SOBRE,
    );
  }
}
