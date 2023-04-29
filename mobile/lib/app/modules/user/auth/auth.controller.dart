import 'package:app/app/data/repository/user.repository.dart';
import 'package:app/app/global/singletons/setings.system.dart';
import 'package:app/app/routes/app_routers.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:shared_preferences/shared_preferences.dart';

class AuthController extends GetxController {
  final repositoty = Get.find<UserRepository>();
  final formKey = GlobalKey<FormState>();

  TextEditingController username = TextEditingController();
  TextEditingController password = TextEditingController();

  validate() async {
    if (formKey.currentState.validate()) {
      if ((username.text != '') && (password.text != '')) {
        await repositoty
            .auth(username.text, password.text, false)
            .then((value) {
          SettingsSystem.instance.user = value;
          _salveDataAuthMemory(value);
          Get.offAndToNamed(Routes.HOME);
        }).catchError((err) {
          Get.snackbar('Erro:',
              'Email ou senha incorreto(s), verifique e tente novamente');
        });
      }
    }
  }

  _salveDataAuthMemory(user) async {
    SharedPreferences _prefs = await SharedPreferences.getInstance();
    _prefs.setString('username', user.username);
    _prefs.setString('password', user.password);
    _prefs.setString('token', user.token);
  }

  sendmail() {
    Get.defaultDialog(
      title: 'Recuperar senha',
      middleText:
          'Deseja enviar um e-mail para verificação de dados do usuário?',
      textConfirm: 'Enviar',
      textCancel: 'Cancelar',
      backgroundColor: Colors.green[100],
      buttonColor: Colors.green,
      barrierDismissible: false,
      onCancel: () => Get.back(),
      onConfirm: () => _sendmail(),
    );
  }

  _sendmail() async {}
}
