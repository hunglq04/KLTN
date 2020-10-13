import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-login-admin',
  templateUrl: './login-admin.component.html',
  styleUrls: ['./login-admin.component.css']
})
export class LoginAdminComponent implements OnInit {

  loginForm: FormGroup;

  constructor   (
    private loginService: AuthenticationService,
    private fb: FormBuilder
  ){}

  ngOnInit() {
    this.loginForm = this.fb.group({
      idCard: '',
      password: ''
    });
  }

  onLogin() {
    console.log("Submit Login");
    
    this.loginService.authenticate("admin", "admin")
      .then(res => {
          console.log(res);
        })
  }

}
