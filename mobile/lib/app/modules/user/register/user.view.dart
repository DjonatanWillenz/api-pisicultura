import 'package:app/app/global/utils/const.text.dart';
import 'package:app/app/global/widgets/widget_button_salvar.dart';
import 'package:app/app/global/widgets/widget_scaffold_cadastro.dart';
import 'package:app/app/global/widgets/widget.text.form.field.dart';
import 'package:app/app/modules/user/register/user.controller.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

class RegisterUserView extends GetView<UserController> {
  @override
  Widget build(BuildContext context) {
    return DwScaffoldCadastro(
      title: UtilsTextLabels.CADASTRAR_USUARIO,
      body: Form(
        key: controller.formKey,
        child: Column(
          children: [
            SizedBox(height: 65),
            DwTextFormField(
                label: "Nome completo:", controll: controller.password),
            DwTextFormField(label: "E-mail:", controll: controller.email),
            DwTextFormField(
                label: "Senha:",
                controll: controller.password,
                isPassword: true),
            DwTextFormField(
              label: "Confirmar senha:",
              controll: controller.confirmPassword,
              isPassword: true,
              funValidarCampo: controller.validarCampoConfirmarSenha,
            ),
            SizedBox(height: 20),
            DwButtonSalvar(funOnTap: () => controller.cadastrarUsuario()),
          ],
        ),
      ),
    );
  }
}
