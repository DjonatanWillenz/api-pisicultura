import 'package:flutter/material.dart';

class DwCheckBox extends StatelessWidget {
  final bool ativo;
  final Function mudarStatus;
  final String label;

  const DwCheckBox({
    Key key,
    this.ativo,
    this.mudarStatus,
    this.label,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      width: MediaQuery.of(context).size.width - 20,
      height: 65,
      alignment: AlignmentDirectional.centerStart,
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(12),
        border: Border.all(
          width: 1,
          color: Colors.black45,
        ),
      ),
      child: Row(
        children: [
          Checkbox(
            onChanged: (bool value) =>
                this.mudarStatus(value), //this.mudarStatus(value),
            value: this.ativo ?? false,
          ),
          Text(label ?? 'Sem descrição')
        ],
      ),
    );
  }
}
