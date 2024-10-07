document.getElementById('registrationForm').addEventListener('submit', function(event) {
    event.preventDefault();
    var name = document.getElementById('name').value;
    var studentId = document.getElementById('studentId').value;
    var phone = document.getElementById('phone').value;
    var college = document.getElementById('college').value;
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirmPassword').value;

    if (password !== confirmPassword) {
        alert('密码和确认密码不匹配！');
        return;
    }

    // 这里可以添加更多的验证逻辑
    // ...

    // 假设验证通过，提交表单
    alert('注册成功！');
});