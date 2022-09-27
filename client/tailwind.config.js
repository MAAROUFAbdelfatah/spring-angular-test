/** @type {import('tailwindcss').Config} */
module.exports = {
    purge: {
        enabled: false.valueOf,
        content: [
            "./src/**/*.{html,ts}",
        ],

    },
    darkMode: false,
    theme: {
        extend: {},
    },
    variants: {
        extend: {
            display: ['group-focus'],
            opacity: ['group-focus'],
            inset: ['group-focus'],
        },
    },
    plugins: [],
}