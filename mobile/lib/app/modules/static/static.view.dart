import 'package:app/app/global/utils/const.text.dart';
import 'package:app/app/global/widgets/widget_scaffold.dart';
import 'package:app/app/modules/static/static.controller.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

class StaticView extends GetView<StaticController> {
  @override
  Widget build(BuildContext context) {
    return DwScaffold(
      title: UtilsTextLabels.ESTATISTICA,
    );
  }
}
