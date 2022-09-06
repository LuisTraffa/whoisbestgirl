

let usernameRegex = new RegExp('^[a-zA-Z0-9_]{3,16}$');

const usernamePopover = new bootstrap.Popover($('#username'), {trigger: 'manual'});

$('.checkUsernameForm').on('submit', (e) => {
    if (!usernameRegex.test($('[name="username"]').val())) {
        e.preventDefault();
        usernamePopover.show();
        setTimeout(() => {
            usernamePopover.hide()
        }, 1000);
    }
});