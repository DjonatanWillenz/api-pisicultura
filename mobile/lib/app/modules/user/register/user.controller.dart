import 'package:app/app/data/model/user.model.dart';
import 'package:app/app/data/repository/user.repository.dart';
import 'package:app/app/global/singletons/setings.system.dart';
import 'package:app/app/routes/app_routers.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

class UserController extends GetxController {
  final repositoty = Get.find<UserRepository>();

  TextEditingController name = TextEditingController();
  TextEditingController email = TextEditingController();
  TextEditingController password = TextEditingController();
  TextEditingController confirmPassword = TextEditingController();

  final formKey = GlobalKey<FormState>();

  cadastrarUsuario() async {
    if (formKey.currentState.validate()) {
      if (password.text == confirmPassword.text) {
        User newUsuario = await repositoty.post(
            User(name: name.text, email: email.text, password: password.text));

        newUsuario == null
            ? Get.snackbar("Erro:", 'Não foi possivel concluir o cadastro!')
            : _realizarLoginAposConcluirCadastro(newUsuario);
      } else
        Get.snackbar("Erro:", 'As senha não correspondem!');
    }
  }

  _realizarLoginAposConcluirCadastro(User user) {
    Get.snackbar('Sucesso!!', 'Seu cadastro foi realizado com sucesso!!');
    SettingsSystem.instance.user = user;
    Get.offAndToNamed(Routes.HOME);
  }

  validarCampoConfirmarSenha() {
    //if (senha.text != confirmarSenha.text)
    return "As senha não correspondem!";
  }
}
