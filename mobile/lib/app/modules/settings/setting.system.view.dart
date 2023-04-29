import 'package:app/app/global/utils/const.text.dart';
import 'package:app/app/global/widgets/widget.option.dart';
import 'package:app/app/global/widgets/widget_scaffold.dart';
import 'package:app/app/modules/settings/setting.system.controller.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

class SettingsSystemView extends GetView<SettingSystemController> {
  @override
  Widget build(BuildContext context) {
    return DwScaffold(
      title: UtilsTextLabels.CONFIG_SYSTEM,
      body: Column(
        children: List.generate(
          controller.settings.length,
          (index) => DwOption(
            title: controller.settings[index].title,
            setting: controller.settings[index].setting,
            onChange: controller.onChanged,
          ),
        ),
      ),
    );
  }
}
