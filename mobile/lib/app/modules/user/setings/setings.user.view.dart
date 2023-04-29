import 'package:app/app/data/enum/setting.enum.dart';
import 'package:app/app/global/utils/constantes.text.dart';
import 'package:app/app/global/widgets/widget.option.dart';
import 'package:app/app/global/widgets/widget_scaffold.dart';
import 'package:app/app/modules/user/setings/setings.user.controller.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

class SetingsUserSystemView extends GetView<SetingsUserController> {
  @override
  Widget build(BuildContext context) {
    return DwScaffold(
      title: UtilsTextLabels.PROFILE,
      body: Padding(
        padding: const EdgeInsets.only(top: 8.0),
        child: Center(
          child: Column(
            children: List.generate(
              controller.settings.length,
              (index) => DwOption(
                title: "Receber notificações",
                enabled: controller.enabledOption(SettingEnum.NOTIFY),
                onChange: controller.onChange,
                setting: SettingEnum.NOTIFY,
              ),
            ),
          ),
        ),
      ),
    );
  }
}
