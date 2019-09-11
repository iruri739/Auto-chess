<template>
  <div class="login">
    <el-container>
      <div class="logo">
        <img src="@/assets/img/logo.png" />
      </div>
      <video id="video" autoplay loop muted="true">
        <source src="@/assets/img/background.mp4" type="video/mp4" />
      </video>

      <el-aside width="355px">
        <el-container>
          <el-form ref="ruleForm" :model="ruleForm" label-width="80px" :rules="rules">
            <el-form-item label></el-form-item>
            <el-form-item label></el-form-item>

            <el-form-item label="用户名" prop="name">
              <el-input v-model="ruleForm.name" placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item label="密   码" prop="password">
              <el-input placeholder="请输入密码" v-model="ruleForm.password" show-password></el-input>
            </el-form-item>
            <el-form-item label prop="type">
              <el-checkbox-group v-model="ruleForm.type">
                <el-checkbox label="请仔细阅读协议" name="type"></el-checkbox>
              </el-checkbox-group>
            </el-form-item>
            <el-form-item>
              <el-button type="text" @click="centerDialogVisible = true">《Superance自走棋用户协议》</el-button>
              <el-dialog
                title="《Superance协议》"
                :visible.sync="centerDialogVisible"
                width="70%"
                center
              >
                <span>
                  1. 许可权利的授予。本《协议》授予您下列权利：《自走棋》网络游戏客户端软件的安装、运行。您可在许可生效的时间内将《自走棋》网络游戏客户端软件安装在自己使用的联网计算机上，并以客户端软件指定的方式运行本“软件产品”的一份副本。其他任何形式的未经许可的安装、使用、访问、显示、运行以及转让，都将被视为对《协议》的侵犯。
                  <br />2. 依本合同规定，著作权人许可您可以通过官方网站许可的方式获取仅授权本产品的客户端软件在一台计算机上使用。产品可以载入个人电脑或永久存取装置的方式使用。本产品可由一部个人电脑移转到另一部个人电脑使用，但不得同时存在于两部电脑中。依本合同第9条移转给他人时，使用者载入个人电脑的部分应予以删除，不得留存使用。
                  <br />3. 禁止性行为或活动。
                  <br />3.1 禁止用户发生以下侵害本网络游戏公平性的行为，包括但不限于：
                  <br />3.1.1 利用反向工程、编译或反向编译、反汇编等技术手段制作软件对游戏进行分析、修改、攻击，最终达到作弊的目的；
                  <br />3.1.2 使用任何外挂程序或游戏修改程序（本协议所称“外挂程序”是指独立于游戏软件之外的，能够在游戏运行的同时影响游戏操作的所有程序，包括但不限于模拟键盘鼠标操作、改变操作环境、修改数据等一切类型。如国家有管法律、法规及政府主管部门的规章或规范性文件规定的外挂定义与本协议有冲突，则以法律、法规、部门规章或规范性文件规定的为准），对本网络游戏软件进行还原工程、编译、译码或修改，包括但不限于修改本软件所使用的任何专有通讯协议、对动态随机存取内存（RAM）中资料进行修改或锁定；
                  <br />3.1.3 使用异常的方法登录游戏、使用网络加速器等外挂软件或机器人程式等恶意破坏服务设施、扰乱正常服务秩序的行为；
                  <br />3.1.4 制作、传播或使用外挂、封包、加速软件，及其它各种作弊程序，或组织、教唆他人使用此类软件程序，或销售此类软件程序而为私人或组织谋取经济利益；
                  <br />3.1.5 使用任何方式或方法，试图攻击提供游戏服务的相关服务器、路由器、交换机以及其他设备，以达到非法获得或修改未经授权的数据资料、影响正常游戏服务，以及其他危害性目的的任何行为；
                  <br />3.1.6 利用软件产品系统可能存在的技术缺陷或漏洞而以各种形式为自己及他人牟利（包括但不限于复制游戏中的虚拟物品等）。
                  <br />3.2 一旦Superance通过内部的监测程序发现或经其他用户举报而发现您有可能正在从事上述行为，则Superance有权采取相应的措施进行弥补，该措施包括但不限于限制您帐号和游戏中角色的登陆、限制您在游戏中的活动、删除与复制有关的物品（包括复制出的虚拟物品和参与复制的虚拟物品）、删除您的帐号和要求您赔偿因您从事上述行为而给Superance造成的损失等。
                  <br />4. 对反向工程(Reverse Engineering)、反向编译(Decompilation)、反汇编(Disassembly)的禁止。您不得对本“软件产品”进行反向工程(Reverse Engineering)、反向编译(Decompile)或反汇编(Disassemble)，您亦同意放弃行使适用法律允许上述活动之权利。
                  <br />5. 服务条款的确认和接纳。本“软件产品”的运营权归Superance。Superance提供的服务完全按照其发布的章程、服务条款和操作规则严格执行。您应该遵守Superance制定的上述管理规定。如果您发生违反此类管理规定的行为，Superance可终止本《协议》并停止您使用“软件产品”的权利。如此类情况发生，您必须立即销毁“软件产品”的所有副本及其所有组成部分。
                  <br />6. 用户必须提供的设备和须提供的信息。Superance提供可使用的“软件产品”，并运用自己的网络系统通过国际互联网络（Internet）为用户提供服务。同时，用户必须：
                  <br />6.1 自行配备上网的所需设备， 包括个人电脑、调制解调器或其他必备上网装置。
                  <br />6.2 自行负担个人上网所支付的与此服务有关的电话费用、网络费用。基于Superance提供服务的重要性，用户应同意：
                  <br />6.2.1 提供详尽、准确的个人资料。
                  <br />6.2.2 不断更新注册资料，符合及时、详尽、准确的要求。
                  <br />6.2.3 牢记您填写的注册资料、历史信息。
                  <br />Superance在为您提供相关客户服务的前提是您能表明您是帐号的所有人，这可能需要您提供相关信息（包括但不限于注册信息、历史密码等），如果用户没有牢记自己填写的注册资料及相关历史信息或未及时更新相关注册资料，您的相关问题（包括但不限于密码找回等）将得不到解决，对此Superance不承担任何责任。
                  <br />7. 拒绝提供担保。用户个人对网络服务的使用承担风险。Superance对以下事宜不作任何类型的担保，不论是明确的或隐含的：
                  <br />7.1 本协议项下的“软件产品”及Superance提供的相关服务将符合用户的要求；
                  <br />7.2 本协议项下的“软件产品”及Superance提供的相关服务将不受不可抗力、计算机病毒、黑客攻击、系统不稳定、用户所在位置、用户关机、电信部门原因及其他任何网络、技术、通信线路等外界或人为因素的影响；
                  <br />7.3 安装、复制、访问网站、充值、运行客户端软件或以其它方式使用“软件产品”及/或接受Superance提供的相关服务与任何其他软件不存在任何冲突；
                  <br />7.4 通过Superance网站、游戏官方网站及其他相关网络上的链接和标签所指向的第三方的商业信誉及其提供服务的质量。
                  <br />8. 免除责任。Superance对任何直接、间接、偶然、特殊及继起的损害不负责任，这些损害可能来自：不正当使用网络服务，非法使用网络服务或用户传送的信息有所变动等方面。用户明确同意其安装、复制、访问网站、充值、运行客户端软件或以其它方式使用“软件产品”及/或接受Superance提供的相关服务所存在的风险将完全由其自己承担。因其安装、复制、访问网站、充值、运行客户端软件或以其它方式使用“软件产品”及/或接受Superance提供的相关服务而产生的一切后果也由其自己承担，Superance对用户不承担任何责任。
                  <br />9. 使用者可以移转本产品和所授之权利（不包括用户的帐号、密码及软件产品中的虚拟物品等）予他人，但是移转时应连同所附产品使用手册、授权合同等一并移转，不得留存任一样使用。且该受让人接受本产品和所授之权利时即视同接受遵守本协议（包括《用户服务条款》、《用户须知》、《玩家守则》、《版权声明》）的全部条款。
                  <br />10. 除本合同有其他规定外，未经Superance书面同意，使用者严格禁止有下列行为（无论是有偿的还是无偿的）：
                  <br />10.1 复制、翻拷、传播和在网络上陈列本产品的程序、使用手册和其它图文音像资料的全部或部分内容。
                  <br />10.2 公开展示和播放本产品的全部或部分内容。
                  <br />10.3 出租本产品于他人。
                  <br />10.4 对本产品的程序、图像、动画和音乐进行还原、反编译、反汇编、剪辑、翻译和改编等任何修改行为。
                  <br />10.5 修改或遮盖本产品程序、图像、动画、包装和手册等内容上的产品名称、公司标志、版权信息等内容。
                  <br />10.6 以本产品作为营业使用。
                  <br />10.7 其它违反著作权法、计算机软件保护条例和相关法规的行为。一旦用户有实施违反上述内容的行为，本产品的授权协议将立即停止。Superance有权通过各种合法途径向因违反上述条款而对Superance造成损害的用户追究法律责任。
                  <br />11. 违约赔偿
                  <br />11.1 用户同意保障和维护Superance及其他用户的利益，如因用户违反有关法律、法规或本协议项下的任何条款而给Superance造成损害，用户同意承担由此造成的损害赔偿责任，该等责任包括但不限于给Superance造成的任何直接或间接损失。
                  <br />11.2 因用户违反有关法律、法规或本协议项下的任何条款导致任何第三方向Superance主张任何索赔、要求或损失的，用户同意赔偿Superance由此产生的任何直接或间接损失。
                  <br />12. 法律适用和争议解决
                  <br />12.1 本协议的订立、履行、解释及争议的解决均应适用中国法律。
                  <br />12.2 如双方就本协议内容或其执行发生任何争议，双方应尽量友好协商解决；协商不成时，任何一方均应向上海市浦东新区人民法院提起诉讼。
                  <br />13. 通知和送达。本协议项下Superance的所有通知均可通过重要页面公告、电子邮件或常规的信件传送等方式进行；该等通知于发送之日视为已送达收件人。
                  <br />14. 其他规定
                  <br />14.1 本“软件产品”受著作权法及国际著作权条约和其它知识产权法和条约的保护；本“软件产品”只许可在给定范围和时间内使用，而不出售其原代码和其他任何相关知识产权权利。
                  <br />14.2 关于本“软件产品”的《用户服务条款》、《用户须知》、《玩家守则》、《版权声明》等文件均属于本《协议》不可分割的一部分，与本《协议》同样有效。
                  <br />14.3 本协议构成双方对本协议之约定事项及其他有关事宜的完整协议，除本协议规定的之外，未赋予本协议各方其他权利。
                  <br />14.4 如本协议中的任何条款无论因何种原因完全或部分无效或不具有执行力，在此情况下，该无效或不具有执行力的部分将被最接近原条款意图的一项有效并可执行的条款所替代，并且本协议的其余条款仍应有效并且有约束力。
                  <br />14.5 本协议中的标题仅为方便而设，不会对本协议的其他条款有限制作用，也不具有任何法律效力。
                </span>
                <span slot="footer" class="dialog-footer">
                  <el-button @click="centerDialogVisible = false">取 消</el-button>
                  <el-button type="primary" @click="centerDialogVisible = false">确 定</el-button>
                </span>
              </el-dialog>
            </el-form-item>

            <el-form-item label>
              <el-button @click="dialogFormVisible = true">注册</el-button>
              <el-button type="primary" @click="submitRule('ruleForm')">登录</el-button>
            </el-form-item>

            <el-form-item label></el-form-item>
          </el-form>
        </el-container>
      </el-aside>
    </el-container>

    <el-dialog
      custom-class="dialogStyle"
      title="注册"
      :visible.sync="dialogFormVisible"
      :show-close="false"
    >
      <el-form :model="regform" ref="regform" :rules="rules">
        <el-form-item label="用户名" :label-width="formLabelWidth" prop="name">
          <el-input v-model="regform.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth" prop="password">
          <el-input v-model="regform.password" show-password autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="重输密码" :label-width="formLabelWidth">
          <el-input v-model="regform.password2" show-password autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label prop="typeq">
          <el-checkbox-group v-model="regform.typeq">
            <el-checkbox label="请仔细阅读协议" name="typeq"></el-checkbox>
          </el-checkbox-group>
        </el-form-item>
        <el-form-item>
          <el-button type="text" @click="centerDialogVisible = true">《Superance自走棋用户协议》</el-button>
          <el-dialog title="《Superance协议》" :visible.sync="centerDialogVisibleq" width="70%" center>
            <span>
              1. 许可权利的授予。本《协议》授予您下列权利：《自走棋》网络游戏客户端软件的安装、运行。您可在许可生效的时间内将《自走棋》网络游戏客户端软件安装在自己使用的联网计算机上，并以客户端软件指定的方式运行本“软件产品”的一份副本。其他任何形式的未经许可的安装、使用、访问、显示、运行以及转让，都将被视为对《协议》的侵犯。
              <br />2. 依本合同规定，著作权人许可您可以通过官方网站许可的方式获取仅授权本产品的客户端软件在一台计算机上使用。产品可以载入个人电脑或永久存取装置的方式使用。本产品可由一部个人电脑移转到另一部个人电脑使用，但不得同时存在于两部电脑中。依本合同第9条移转给他人时，使用者载入个人电脑的部分应予以删除，不得留存使用。
              <br />3. 禁止性行为或活动。
              <br />3.1 禁止用户发生以下侵害本网络游戏公平性的行为，包括但不限于：
              <br />3.1.1 利用反向工程、编译或反向编译、反汇编等技术手段制作软件对游戏进行分析、修改、攻击，最终达到作弊的目的；
              <br />3.1.2 使用任何外挂程序或游戏修改程序（本协议所称“外挂程序”是指独立于游戏软件之外的，能够在游戏运行的同时影响游戏操作的所有程序，包括但不限于模拟键盘鼠标操作、改变操作环境、修改数据等一切类型。如国家有管法律、法规及政府主管部门的规章或规范性文件规定的外挂定义与本协议有冲突，则以法律、法规、部门规章或规范性文件规定的为准），对本网络游戏软件进行还原工程、编译、译码或修改，包括但不限于修改本软件所使用的任何专有通讯协议、对动态随机存取内存（RAM）中资料进行修改或锁定；
              <br />3.1.3 使用异常的方法登录游戏、使用网络加速器等外挂软件或机器人程式等恶意破坏服务设施、扰乱正常服务秩序的行为；
              <br />3.1.4 制作、传播或使用外挂、封包、加速软件，及其它各种作弊程序，或组织、教唆他人使用此类软件程序，或销售此类软件程序而为私人或组织谋取经济利益；
              <br />3.1.5 使用任何方式或方法，试图攻击提供游戏服务的相关服务器、路由器、交换机以及其他设备，以达到非法获得或修改未经授权的数据资料、影响正常游戏服务，以及其他危害性目的的任何行为；
              <br />3.1.6 利用软件产品系统可能存在的技术缺陷或漏洞而以各种形式为自己及他人牟利（包括但不限于复制游戏中的虚拟物品等）。
              <br />3.2 一旦Superance通过内部的监测程序发现或经其他用户举报而发现您有可能正在从事上述行为，则Superance有权采取相应的措施进行弥补，该措施包括但不限于限制您帐号和游戏中角色的登陆、限制您在游戏中的活动、删除与复制有关的物品（包括复制出的虚拟物品和参与复制的虚拟物品）、删除您的帐号和要求您赔偿因您从事上述行为而给Superance造成的损失等。
              <br />4. 对反向工程(Reverse Engineering)、反向编译(Decompilation)、反汇编(Disassembly)的禁止。您不得对本“软件产品”进行反向工程(Reverse Engineering)、反向编译(Decompile)或反汇编(Disassemble)，您亦同意放弃行使适用法律允许上述活动之权利。
              <br />5. 服务条款的确认和接纳。本“软件产品”的运营权归Superance。Superance提供的服务完全按照其发布的章程、服务条款和操作规则严格执行。您应该遵守Superance制定的上述管理规定。如果您发生违反此类管理规定的行为，Superance可终止本《协议》并停止您使用“软件产品”的权利。如此类情况发生，您必须立即销毁“软件产品”的所有副本及其所有组成部分。
              <br />6. 用户必须提供的设备和须提供的信息。Superance提供可使用的“软件产品”，并运用自己的网络系统通过国际互联网络（Internet）为用户提供服务。同时，用户必须：
              <br />6.1 自行配备上网的所需设备， 包括个人电脑、调制解调器或其他必备上网装置。
              <br />6.2 自行负担个人上网所支付的与此服务有关的电话费用、网络费用。基于Superance提供服务的重要性，用户应同意：
              <br />6.2.1 提供详尽、准确的个人资料。
              <br />6.2.2 不断更新注册资料，符合及时、详尽、准确的要求。
              <br />6.2.3 牢记您填写的注册资料、历史信息。
              <br />Superance在为您提供相关客户服务的前提是您能表明您是帐号的所有人，这可能需要您提供相关信息（包括但不限于注册信息、历史密码等），如果用户没有牢记自己填写的注册资料及相关历史信息或未及时更新相关注册资料，您的相关问题（包括但不限于密码找回等）将得不到解决，对此Superance不承担任何责任。
              <br />7. 拒绝提供担保。用户个人对网络服务的使用承担风险。Superance对以下事宜不作任何类型的担保，不论是明确的或隐含的：
              <br />7.1 本协议项下的“软件产品”及Superance提供的相关服务将符合用户的要求；
              <br />7.2 本协议项下的“软件产品”及Superance提供的相关服务将不受不可抗力、计算机病毒、黑客攻击、系统不稳定、用户所在位置、用户关机、电信部门原因及其他任何网络、技术、通信线路等外界或人为因素的影响；
              <br />7.3 安装、复制、访问网站、充值、运行客户端软件或以其它方式使用“软件产品”及/或接受Superance提供的相关服务与任何其他软件不存在任何冲突；
              <br />7.4 通过Superance网站、游戏官方网站及其他相关网络上的链接和标签所指向的第三方的商业信誉及其提供服务的质量。
              <br />8. 免除责任。Superance对任何直接、间接、偶然、特殊及继起的损害不负责任，这些损害可能来自：不正当使用网络服务，非法使用网络服务或用户传送的信息有所变动等方面。用户明确同意其安装、复制、访问网站、充值、运行客户端软件或以其它方式使用“软件产品”及/或接受Superance提供的相关服务所存在的风险将完全由其自己承担。因其安装、复制、访问网站、充值、运行客户端软件或以其它方式使用“软件产品”及/或接受Superance提供的相关服务而产生的一切后果也由其自己承担，Superance对用户不承担任何责任。
              <br />9. 使用者可以移转本产品和所授之权利（不包括用户的帐号、密码及软件产品中的虚拟物品等）予他人，但是移转时应连同所附产品使用手册、授权合同等一并移转，不得留存任一样使用。且该受让人接受本产品和所授之权利时即视同接受遵守本协议（包括《用户服务条款》、《用户须知》、《玩家守则》、《版权声明》）的全部条款。
              <br />10. 除本合同有其他规定外，未经Superance书面同意，使用者严格禁止有下列行为（无论是有偿的还是无偿的）：
              <br />10.1 复制、翻拷、传播和在网络上陈列本产品的程序、使用手册和其它图文音像资料的全部或部分内容。
              <br />10.2 公开展示和播放本产品的全部或部分内容。
              <br />10.3 出租本产品于他人。
              <br />10.4 对本产品的程序、图像、动画和音乐进行还原、反编译、反汇编、剪辑、翻译和改编等任何修改行为。
              <br />10.5 修改或遮盖本产品程序、图像、动画、包装和手册等内容上的产品名称、公司标志、版权信息等内容。
              <br />10.6 以本产品作为营业使用。
              <br />10.7 其它违反著作权法、计算机软件保护条例和相关法规的行为。一旦用户有实施违反上述内容的行为，本产品的授权协议将立即停止。Superance有权通过各种合法途径向因违反上述条款而对Superance造成损害的用户追究法律责任。
              <br />11. 违约赔偿
              <br />11.1 用户同意保障和维护Superance及其他用户的利益，如因用户违反有关法律、法规或本协议项下的任何条款而给Superance造成损害，用户同意承担由此造成的损害赔偿责任，该等责任包括但不限于给Superance造成的任何直接或间接损失。
              <br />11.2 因用户违反有关法律、法规或本协议项下的任何条款导致任何第三方向Superance主张任何索赔、要求或损失的，用户同意赔偿Superance由此产生的任何直接或间接损失。
              <br />12. 法律适用和争议解决
              <br />12.1 本协议的订立、履行、解释及争议的解决均应适用中国法律。
              <br />12.2 如双方就本协议内容或其执行发生任何争议，双方应尽量友好协商解决；协商不成时，任何一方均应向上海市浦东新区人民法院提起诉讼。
              <br />13. 通知和送达。本协议项下Superance的所有通知均可通过重要页面公告、电子邮件或常规的信件传送等方式进行；该等通知于发送之日视为已送达收件人。
              <br />14. 其他规定
              <br />14.1 本“软件产品”受著作权法及国际著作权条约和其它知识产权法和条约的保护；本“软件产品”只许可在给定范围和时间内使用，而不出售其原代码和其他任何相关知识产权权利。
              <br />14.2 关于本“软件产品”的《用户服务条款》、《用户须知》、《玩家守则》、《版权声明》等文件均属于本《协议》不可分割的一部分，与本《协议》同样有效。
              <br />14.3 本协议构成双方对本协议之约定事项及其他有关事宜的完整协议，除本协议规定的之外，未赋予本协议各方其他权利。
              <br />14.4 如本协议中的任何条款无论因何种原因完全或部分无效或不具有执行力，在此情况下，该无效或不具有执行力的部分将被最接近原条款意图的一项有效并可执行的条款所替代，并且本协议的其余条款仍应有效并且有约束力。
              <br />14.5 本协议中的标题仅为方便而设，不会对本协议的其他条款有限制作用，也不具有任何法律效力。
            </span>
            <span slot="footer" class="dialog-footer">
              <el-button @click="centerDialogVisibleq = false">取 消</el-button>
              <el-button type="primary" @click="centerDialogVisibleq = false">确 定</el-button>
            </span>
          </el-dialog>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="clear()">取 消</el-button>
        <el-button type="primary" @click="submitReg('regform')">确 定</el-button>
      </div>
    </el-dialog>

    <div class="sixteen">
      <span>
        <p>
          <strong>合理安排时间&nbsp;享受健康生活&nbsp;注意自我保护&nbsp;拒绝盗版游戏</strong>
        </p>
      </span>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      id: 0,
      centerDialogVisible: false,
      centerDialogVisibleq: false,
      users: [],
      formLabelWidth: "120px",
      ruleForm: {
        name: "",
        password: "",
        type: [],
        checked: true
      },
      regform: {
        name: "",
        password: "",
        password2: "",
        typeq: [],
        checked: true
      },
      dialogFormVisible: false,
      gridData: {},
      rules: {
        name: [
          { required: true, message: "用户名输入不正确", trigger: "blur" },
          {
            min: 3,
            max: 15,
            message: "长度在 3 到 15 个字符",
            trigger: "blur"
          },
          { pattern: /^[A-Za-z0-9]+$/, message: "只能输入数字和英文" }
        ],
        password: [{ required: true, message: "请输入密码", trigger: "blur" },
                   { min: 4,max: 15,message: "长度在 4 到 15 个字符",trigger: "blur"}],
        type: [
          {
            type: "array",
            required: true,
            message: "请仔细阅读协议并确认",
            trigger: "change"
          }
        ],
        typeq: [
          {
            type: "array",
            required: true,
            message: "请仔细阅读协议并确认",
            trigger: "change"
          }
        ]
      }
    };
  },
  methods: {
    submitReg(regform) {
      this.$refs[regform].validate(valid => {
        if (valid) {
          if (
            this.regform.password &&
            this.regform.password === this.regform.password2
          ) {
            this.axios
              .post("/serveApi/user/register/", {
                userName: this.regform.name,
                userPwd: this.regform.password
              })
              .then(resp => {
                if (resp.data != 0) {
                  this.$router.push({
                    name: "Menu",
                    query: {
                      id: resp.data
                    }
                  });
                  this.$message({
                    type: "success",
                    message: `注册成功！`
                  });
                } else {
                  this.$message({
                    type: "warning",
                    message: `用户名已存在！`
                  });
                }
              });
          } else {
            this.$message({
              type: "warning",
              message: `两次密码不一样或没输入 ！`
            });
          }
        } else {
          return false;
        }
      });
    },
    submitRule(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          var username = this.ruleForm.name;
          var password = this.ruleForm.password;

         let abc= this.axios
            .get(
              `/serveApi/user/login?userName=${username}&userPwd=${password}`
            )
            .then(resp => {
              this.id = resp.data;
              if (resp.data != 0) {
                this.$router.push({
                  name: "Menu",
                  query: {
                    id: this.id
                  }
                });
                this.$message({
                  type: "success",
                  message: `登录成功 ！`
                });
              } else {
                this.$message.error(`用户名或者密码不正确 ！`);
              }
            }).catch(err=>{
            });

        }
      });
    },
          //             if(this.id!=0){
          //              this.$http.get('serveApi/user/check?userId='+this.id).then(resp => {
          //                alert(resp.data)
          //          if(resp.data=true){
          //               this.$router.push({
          //                name: "Home" ,
          //                query:{
          //                  id:this.id
          //                }
          //                });
          //          }else{
          //          }
          // })
          //                                  }
          //     if(resp.data!=0){
          //      this.$router.push({
          //        name: "Menu" ,
          //        query:{
          //          id:resp.data
          //        }
          //        });
          //  }
        
    clear() {
      this.dialogFormVisible = false;
      this.regform.name = "";
      this.regform.password = "";
      this.regform.password2 = "";
    }
  }
};
</script>
<style>
.login .sixteen {
  height: 40px;
  width: 400px;
  position: absolute;
  top: 90%;
  left: 70%;
}
.login .logo {
  position: absolute;
  right: 30px;
  z-index: 5;
}
.login .el-dialog.dialogStyle {
  background-image: url("../assets/img/register.jpg");
  background-size: cover;
}

.login #video {
  position: fixed;
  right: 0;
  bottom: 0;
  margin: 0;
  z-index: -1;
  width: 1366px;
  height: 768px;
}
.login .el-aside {
  background-color: lightgray;
  margin-top: 200px;
  position: absolute;
  right: 20px;
}
.login {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;
}
</style>