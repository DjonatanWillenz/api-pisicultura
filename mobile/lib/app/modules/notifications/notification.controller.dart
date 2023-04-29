import 'package:app/app/data/model/notification.model.dart';
import 'package:app/app/data/repository/notification.repository.dart';
import 'package:app/app/global/singletons/setings.system.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

class NotificationController extends GetxController {
  final formKey = GlobalKey<FormState>();

  NotificationRepository repository = Get.find<NotificationRepository>();

  TextEditingController title = TextEditingController();
  TextEditingController description = TextEditingController();

  validInfo() async {
    if (formKey.currentState.validate()) {
      if (await repository.register(Notifications(
              title: title.text, description: description.text)) !=
          null) {
        Get.snackbar("Ok", 'Cadastrado com sucesso!!');
      }
    }
  }

  Future<bool> deleteById(int id) async {
    return await repository.deletar(id);
  }

  Future<List<Notifications>> findByIdUser() async {
    return await repository.getNotifications(SettingsSystem.instance.user.id);
  }
}
