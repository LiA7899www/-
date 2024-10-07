var codeBtn = document.getElementById('codeBtn');

// 启动倒计时函数
function startCountdown(duration, btn) {
    var seconds = parseInt(duration / 1000, 10);
    var intervalId = setInterval(function() {
        btn.value = seconds + "秒后重新获取";
        if (seconds > 0) {
            seconds -= 1;
            btn.disabled = true; // 禁用按钮
        } else {
            clearInterval(intervalId);
            btn.value = "获取验证码";
            btn.disabled = false; // 启用按钮
        }
    }, 1000);
}

// 添加事件监听器
codeBtn.addEventListener('click', function() {
    if (!codeBtn.disabled) {
        // 启动倒计时，设置为60秒
        startCountdown(60000, codeBtn);
    }
});


