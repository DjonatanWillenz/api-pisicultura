import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

class TaskController extends GetxController {
  final formKey = GlobalKey<FormState>();

  // TaskRepository repository = Get.find<TaskRepository>();

  // TextEditingController title = TextEditingController();
  // TextEditingController description = TextEditingController();

  // validInfo() async {
  //   if (formKey.currentState.validate()) {
  //     if (await repository.register(Notifications(
  //             title: title.text, description: description.text)) !=
  //         null) {
  //       Get.snackbar("Ok", 'Cadastrado com sucesso!!');
  //     }
  //   }
  // }

  // Future<bool> deleteById(int id) async {
  //   return await repository.deletar(id);
  // }

  // Future<List<Notifications>> findByIdUser() async {
  //   return await repository.getNotifications(SettingsSystem.instance.user.id);
  // }
}
