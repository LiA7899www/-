document.addEventListener('DOMContentLoaded', function() {
    // 获取所有的输入框
    var inputs = document.querySelectorAll('.inputItem');

    // 为每个输入框添加事件监听器
    inputs.forEach(function(input) {
        // 保存原始的placeholder值
        input.setAttribute('data-placeholder', input.placeholder);

        input.addEventListener('focus', function() {
            // 当输入框获得焦点时，清除placeholder
            input.placeholder = '';
        });

        input.addEventListener('blur', function() {
            // 当输入框失去焦点且没有输入时，恢复placeholder
            if (input.value === '') {
                input.placeholder = input.getAttribute('data-placeholder');
            }
        });

        // 当点击其他输入框时，检查当前输入框是否有内容
        inputs.forEach(function(otherInput) {
            otherInput.addEventListener('focus', function() {
                if (input !== otherInput && input.value === '') {
                    input.placeholder = input.getAttribute('data-placeholder');
                }
            });
        });
    });
});
