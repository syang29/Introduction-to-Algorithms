\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{cse331-template}[2017/06/09 CSE331 Algorithms Homework Class]

\LoadClass[11pt]{article}

\RequirePackage[hidelinks]{hyperref}

%\usepackage[margin=0.5in]{geometry} % Advanced page geometry configuation
\usepackage[letterpaper, top=0.9in, bottom=0.9in, left=0.7in, right=0.7in]{geometry}

\RequirePackage{fancyhdr}
\pagestyle{fancy}
\fancyhf{}
\renewcommand{\headrulewidth}{0.4pt}
\renewcommand{\footrulewidth}{0.4pt}

\RequirePackage{mathtools}
\RequirePackage{algorithm}
\RequirePackage{algpseudocode}

\RequirePackage{tabularx}
\RequirePackage{ragged2e}
\RequirePackage{indentfirst}

\RequirePackage{fourier}
\RequirePackage[T1]{fontenc}

%\RequirePackage{fullpage}

%%%%%%%%%%%%%%%%%%%
% Custom Commands %
%%%%%%%%%%%%%%%%%%%

% Reminder to submit as PDFs and input entries in AutoLab
\newif\if@reminder
\@remindertrue
\newcommand{\removereminder}{\@reminderfalse}

%%%%%%%%%%%%%%%%%%%
% Header & Footer %
%%%%%%%%%%%%%%%%%%%

\fancyhead[L]{CSE 331}
\fancyhead[R]{Fall 2018}
\fancyfoot[R]{\thepage}

\renewcommand\maketitle{
    {\centering\huge\@title\par}
    \vspace{10pt}
    \hrule
    
    \begin{center}    \textbf{Name:} \@author \end{center}
    \hrule
   
    \if@reminder%
      \begin{center} 

        \textit{Don't forget to input your list of collaborators and sources on \textbf{AutoLab}.}

        \textbf{Please submit this file as a PDF.}
    \end{center}
    \fi
}


