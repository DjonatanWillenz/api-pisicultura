import 'package:app/app/global/utils/constantes.text.dart';
import 'package:app/app/global/widgets/widget.scaffold.listagem.dart';
import 'package:app/app/modules/administrative/administrative.controller.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

class AdministrativeView extends GetView<AdministrativeController> {
  @override
  Widget build(BuildContext context) {
    return DwScaffoldListagem(
      title: UtilsTextLabels.ADMINISTRATIVO,
    );
  }
}
